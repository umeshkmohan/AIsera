package org.umesh.util

import java.text.SimpleDateFormat
import java.util.{Locale, TimeZone}


object UtilFunctions {

  /**
    * @param  messageString pass the message column
    * @return Only the no of messages
    */
  def parseMessage = (messageString: String) => {
    val parseInput = (messageString.replaceAll("[^0-9]", ""))
    parseInput
  }

  /**
    * @param  datePart pass the DATE value with Timezone
    * @return date value in YYYY-MM-DD format
    */

def parseDate= (datePart: String) => {
  datePart.substring(0,10)
}


  //  def parseDate= (datePart: String) => {
  //    val datePattern = "yyyy-MM-dd'T'HH:mm:ss"
  //    val inputFormat = new SimpleDateFormat(datePattern, Locale.US)
  //    inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
  //    inputFormat.parse(datePart)
  //    inputFormat.applyPattern("YYYY-MM-DD").toString
  //  }


}


