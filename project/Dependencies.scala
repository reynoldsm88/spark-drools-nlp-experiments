import sbt._

object Dependencies {

    val slf4jVersion = "1.7.5"
    val logbackVersion = "1.1.7"
    val sparkVersion = "2.2.0"
    val sparkTestBaseVersion = "2.2.0_0.8.0"
    val kiegroupVersion = "7.4.1.Final"
    val betterFilesVersion = "2.16.0"
    val opennlpVersion = "1.8.3"
    val hadoopVersion = "2.7.4"
    val scalaTestVersion = "3.0.4"
    val gensonVersion = "1.4"
    val okhttpVersion = "3.10.0"


    val slf4j = Seq( "org.slf4j" % "slf4j-api" % slf4jVersion )

    val logback = Seq( "ch.qos.logback" % "logback-classic" % logbackVersion )

    val spark = Seq( "org.apache.spark" %% "spark-core" % sparkVersion % "provided" )

    val sparkTestBase = Seq( "com.holdenkarau" %% "spark-testing-base" % sparkTestBaseVersion % "test" )

    val drools = Seq( "org.drools" % "drools-core" % kiegroupVersion,
                      "org.drools" % "drools-compiler" % kiegroupVersion )

    val droolsTest = Seq( "org.drools" % "drools-core" % kiegroupVersion % "test",
                          "org.drools" % "drools-compiler" % kiegroupVersion % "test" )

    val kie = Seq( "org.kie" % "kie-api" % kiegroupVersion,
                   "org.kie" % "kie-internal" % kiegroupVersion,
                   "org.kie" % "kie-ci" % kiegroupVersion )

    val kieTest = Seq( "org.kie" % "kie-api" % kiegroupVersion % "test",
                       "org.kie" % "kie-internal" % kiegroupVersion % "test",
                       "org.kie" % "kie-ci" % kiegroupVersion % "test" )

    val opennlp = Seq( "org.apache.opennlp" % "opennlp-tools" % opennlpVersion )

    val hadoop = Seq( "org.apache.hadoop" % "hadoop-common" % hadoopVersion,
                      "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion,
                      "org.apache.hadoop" % "hadoop-client" % hadoopVersion )

    val hadoopTest = Seq( "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion % "test" classifier "tests",
                          "org.apache.hadoop" % "hadoop-common" % hadoopVersion % "test" classifier "tests" )

    val scalaTest = Seq( "org.scalatest" %% "scalatest" % scalaTestVersion % "test" )

    val gensonJSON = Seq( "com.owlike" % "genson-scala_2.11" % gensonVersion )

    val okhttp = Seq( "com.squareup.okhttp3" % "okhttp" % okhttpVersion )

}