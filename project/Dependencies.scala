import sbt.Keys._
import sbt._

object Dependencies {

    val slf4jVersion = "1.7.5"
    val logbackVersion = "1.1.7"
    val sparkVersion = "2.2.0"
    val kiegroupVersion = "7.4.1.Final"
    val betterFilesVersion = "2.16.0"
    val opennlpVersion = "1.8.3"
    val hadoopVersion = "2.7.4"
    val scalaTestVersion = "3.0.4"


    val slf4j = Seq( "org.slf4j" % "slf4j-api" % slf4jVersion )

    val logback = Seq( "ch.qos.logback" % "logback-classic" % logbackVersion )

    val spark = Seq( "org.apache.spark" %% "spark-core" % sparkVersion % "provided" )

    val drools = Seq( "org.drools" % "drools-core" % kiegroupVersion,
                      "org.drools" % "drools-compiler" % kiegroupVersion )

    val kie = Seq( "org.kie" % "kie-api" % kiegroupVersion,
                   "org.kie" % "kie-internal" % kiegroupVersion,
                   "org.kie" % "kie-ci" % kiegroupVersion )

    val opennlp = Seq( "org.apache.opennlp" % "opennlp-tools" % opennlpVersion )

    // forgot why i had this but i don't want to throw it away
    //    val betterFiles = Seq( "com.github.pathikrit" %% "better-files" % betterFilesVersion )

    val hadoop = Seq( "org.apache.hadoop" % "hadoop-common" % hadoopVersion,
                      "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion,
                      "org.apache.hadoop" % "hadoop-client" % hadoopVersion )

    val hadoopTest = Seq( "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion % "test" classifier "tests",
                          "org.apache.hadoop" % "hadoop-common" % hadoopVersion % "test" classifier "tests" )

    val scalaTest = Seq( "org.scalatest" %% "scalatest" % scalaTestVersion % "test" )
}