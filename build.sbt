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
lazy val root = ( project in file( "." ) ).aggregate( model, ngramExtractor, rules )

lazy val model = ( project in file( "model" ) ).settings( libraryDependencies ++= scalaTest  )


lazy val rules = ( project in file( "ngram-rules" ) )
                                    .dependsOn( model )
                                    .settings( libraryDependencies ++= kieTest ++ droolsTest ++ scalaTest  )
//                                    .disablePlugins( sbtassembly.AssemblyPlugin )

lazy val ngramExtractor = ( project in file( "ngram-extractor" ) )
                                    .dependsOn( model )
                                    .settings( libraryDependencies ++= spark ++ opennlp ++ drools ++ kie ++ sparkTestBase ++ scalaTest )

// TODO - I don't think i need this anymore
//lazy val hdfsImport = ( project in file( "hdfs-import" ) )
//                                    .dependsOn( model )
//                                    .settings( libraryDependencies ++= hadoop ++ scalaTest ++ hadoopTest  )

//@formatter:off