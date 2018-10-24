package org.umesh.queries

import org.apache.spark.sql.DataFrame

object Queries {

  /**
    * Query to fetch the "Users registered in each Year"
    * @param dataframe
    * @return dataframe
    */
   def query1(baseDF: DataFrame) = {
    val metricSet1 = baseDF.transform { ds =>
      baseDF.groupBy("registered").count()
    }
     metricSet1
  }


  /**
    * Query to fetch the "Median for Number of Friends,Median age for Users,Mean Balance Amount"
    * @param dataframe
    * @return dataframe
    */
   def query2(baseDF: DataFrame) = {
    val metricSet2 = baseDF.transform { ds =>
      baseDF.selectExpr("percentile_approx(numOfFrnds, 0.5,1000) as medianFriends", "percentile_approx(age, 0.5,1000) as medianAge", "Avg(balance) as meanBalance")
    }
     metricSet2
  }


  /**
    * Query to fetch the "Mean for number of Unread messages for Active females"
    * @param dataframe
    * @return dataframe
    */
  def query3(baseDF: DataFrame) = {
    val metricSet3 = baseDF.transform { ds =>
      baseDF.filter("isActive=true").filter("gender='female'").selectExpr("round(Avg(messagesCount))")
    }
    metricSet3
  }

}
