import sbt._
import Dependencies._

organization := "org.reynoldsm88"
name := "spark-drools-experiments"
version := "0.0.1-SNAPSHOT"
scalaVersion in ThisBuild := "2.11.11"

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/",
                                "Maven Central" at "https://repo1.maven.org/maven2/",
                                "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/" )
//@formatter:off
lazy val root = ( project in file( "." ) ).aggregate( model, ngramExtractor )

lazy val model = ( project in file( "model" ) )

lazy val ngramExtractor = ( project in file( "ngram-extractor" ) )
                                    .dependsOn( model )
                                    .settings( libraryDependencies ++= spark ++ opennlp )
//@formatter:off