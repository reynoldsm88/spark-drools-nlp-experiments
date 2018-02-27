organization := "org.reynoldsm88"
name := "ngram-extractor"
version := "0.0.1-SNAPSHOT"

enablePlugins( JavaAppPackaging )

assemblyMergeStrategy in assembly := {
    case PathList( "META-INF", "MANIFEST.MF" ) => MergeStrategy.discard
    case PathList( "reference.conf" ) => MergeStrategy.concat
    case x => MergeStrategy.first
}