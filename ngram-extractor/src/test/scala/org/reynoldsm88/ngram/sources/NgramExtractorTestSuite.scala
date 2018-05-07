package org.reynoldsm88.ngram.sources

import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.reynoldsm88.ngram.extractor.NgramExtractor
import org.reynoldsm88.ngram.extractor.config.{JobConfig, RulesDescriptor, SourceDescriptor}
import org.scalatest.FlatSpec

class NgramExtractorTestSuite extends FlatSpec with SharedSparkContext with RDDComparisons {

    private val testDataRootDir = System.getProperty( "user.dir" ) + "/ngram-extractor/src/test/resources/data"

    "Ngram Extractor" should "filter, parse, and add sentence boundaries an example Google Hangouts file" in {

        val jobConfig : JobConfig = {
            val metadata = Map( "username" -> "Michael Reynolds" )
            val rules = RulesDescriptor( "org.reynoldsm88", "ngram-rules", "0.0.1-SNAPSHOT" )
            val sources = List( SourceDescriptor( testDataRootDir + "/input/hangouts-sample-input.txt", "hangouts", metadata ) )
            JobConfig( "hangouts-ngram-extractor", rules, sources )
        }

        val extractor : NgramExtractor = new NgramExtractor( jobConfig, sc )
        val actual = extractor.loadSources( jobConfig )
        val expected = sc.textFile( testDataRootDir + "/output/hangouts-sample-expected.txt" )
        assertRDDEquals( expected, actual )
    }
}