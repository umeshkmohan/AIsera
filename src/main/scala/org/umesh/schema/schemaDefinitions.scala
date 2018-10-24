package org.umesh.schema

import org.apache.spark.sql.types._


object SchemaDefinitions {

  val schema = StructType(
    StructField("guid", StringType, nullable = true) ::
      StructField("isActive", BooleanType, nullable = true) ::
      StructField("balance", StringType, nullable = true) ::
      StructField("age", IntegerType, nullable = true) ::
      StructField("eyeColor", StringType, nullable = true) ::
      StructField("name", StringType, nullable = true) ::
      StructField("gender", StringType, nullable = true) ::
      StructField("email", StringType, nullable = true) ::
      StructField("phone", StringType, nullable = true) ::
      StructField("address", StringType, nullable = true) ::
      StructField("registered", StringType, nullable = true) ::
      StructField("friends", ArrayType(StructType(Array( StructField("name", StringType,true))))) ::
      StructField("greeting", StringType, nullable = true) ::
      StructField("favoriteFruit", StringType, nullable = true) ::Nil
  )

}


