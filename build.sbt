name := "AIsera"

version := "0.1"

scalaVersion := "2.11.8"

val spark = "org.apache.spark"
val sparkVersion = "2.3.1"

libraryDependencies += spark %% "spark-core" % sparkVersion
libraryDependencies += spark %% "spark-sql" % sparkVersion
libraryDependencies += spark %% "spark-hive" % sparkVersion
libraryDependencies += spark %% "spark-streaming" % sparkVersion
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test->default"


resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"
resolvers += "Typesafe Simple Repository" at "http://repo.typesafe.com/typesafe/simple/maven-releases/"
resolvers += "Apache repo" at "http://repository.apache.org/content/repositories/releases"

 