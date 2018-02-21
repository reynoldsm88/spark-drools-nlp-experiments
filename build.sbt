import sbt._
import Dependencies._

organization := "org.reynoldsm88"
name := "spark-drools-experiments"
version := "0.0.1-SNAPSHOT"
scalaVersion in ThisBuild := "2.11.11"

publishMavenStyle := true

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/",
                                "Maven Central" at "https://repo1.maven.org/maven2/",
                                "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/" )
//@formatter:off
lazy val root = ( project in file( "." ) ).aggregate( hdfsImport, hdfsCommon, testUtils, model, ngramExtractor )

lazy val model = project in file( "model" )

lazy val ngramExtractor = ( project in file( "ngram-extractor" ) )
                                    .dependsOn( model )
                                    .settings( libraryDependencies ++= spark ++ opennlp ++ drools ++ kie )

lazy val hdfsImport = ( project in file( "hdfs-import" ) )
                                    .dependsOn( model, hdfsCommon, testUtils % "test->test" )
                                    .settings( libraryDependencies ++= hadoop ++ scalaTest )

lazy val hdfsCommon = ( project in file( "hdfs-common" ) )
                                    .settings( libraryDependencies ++= hadoop )

lazy val testUtils = ( project in file( "test-utils" ) )
                                    .dependsOn( hdfsCommon )
                                    .settings( libraryDependencies ++= hadoop ++ hadoopTest )
//@formatter:off