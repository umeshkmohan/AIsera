package org.umesh.test
import org.apache.spark.sql.SparkSession
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import org.umesh.report.UserSummaryStreams._
import org.umesh.util.UtilFunctions
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class UtilFunctionsTest  extends FlatSpec with Matchers with BeforeAndAfterAll{

  implicit var ss: SparkSession = _

  override protected def beforeAll(): Unit = {
    ss = SparkSession
      .builder()
      .appName("Spark SQL Solution ")
      .config("spark.master", "local")
      .getOrCreate()
  }

  case class Data (guid: String,
                    gender: String,
                    isActive: Boolean,
                    registered: String,
                    age: Int,
                    balance: BigDecimal,
                    messagesCount: Int,
                    noFrnds: Int
                  )

  it should "convert date to 2018-10-14" in {
    println(UtilFunctions.parseDate("2018-10-14T04:11:28 +08:00"))
  }

  it should "produce 82 as output" in {
    println(UtilFunctions.parseMessage("Hello, Esperanza Wilkerson! You have 82 unread messages"))
  }

}
