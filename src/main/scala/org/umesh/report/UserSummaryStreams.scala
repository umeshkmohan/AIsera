package org.umesh.report

 import org.apache.spark.sql.{Dataset, Row, SparkSession}
 import org.apache.spark.sql.streaming.Trigger
 import org.slf4j.LoggerFactory
 import org.umesh.util.UtilFunctions.{parseDate, parseMessage}
 import org.umesh.schema.SchemaDefinitions._
 import org.umesh.queries.Queries._


object UserSummaryStreams {

  val log = LoggerFactory.getLogger("print_metrics_aisera")

  /**
    * These variables could be fetched from a configuration file
    */
  val inputPath = "/Users/umohan/gitrepo/aisera/src/main/Resources/"
  val outputFormat = "console"
  val outputType = "update"

  /**
    * Initialize spark session
    */
  val spark = SparkSession
    .builder()
    .appName("Spark Streaming Solution")
    .config("spark.master", "local")
    .getOrCreate()

  /**
    * Declare the UDFs
    */
  spark.sqlContext.udf.register("parseDate",parseDate)
  spark.sqlContext.udf.register("parseMessage",parseMessage)


  def main(args: Array[String]): Unit = {

    /**
      * Input could be declared via configuration
      * In this project its reading the json data as streams
      */
    val inputDF = spark.readStream
      .schema(schema)
      .option("multiLine", true)
      .option("rowsPerSecond",1000)
      .json(inputPath)

    /**
      * Strip only the columns needed for the final metrics
      */
    val baseDF = inputDF.selectExpr("guid","gender","isActive","parseDate(registered) as registered","age","cast(replace(Substring(balance,2), ',', '') as decimal(10,2)) as balance","parseMessage(greeting) as messagesCount","size(friends) as numOfFrnds")

    /**
      * Declare the streaming queries
      */
    val metricSet1: Dataset[Row] = query1(baseDF)
    val metricSet2: Dataset[Row] = query2(baseDF)
    val metricSet3: Dataset[Row] = query3(baseDF)

    /**
      * process all the queries in parallel
      */
    writeStreams(Seq(metricSet1,metricSet2,metricSet3))
  }


  /**
    * Writes the output as streams
    * @param Datasets
    *
    */

  private def writeStreams(datasets: Seq[Dataset[Row]]) = {
    for (dataset <- datasets) {
      dataset.writeStream
        .outputMode(outputType)
        .format(outputFormat)
        //.trigger(Trigger.ProcessingTime("2 seconds"))
        .start()
    }
      .awaitTermination();
  }



}
