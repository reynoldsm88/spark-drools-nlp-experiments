package org.reynoldsm88.ngram.sources

import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.apache.spark.rdd.RDD
import org.scalatest.FlatSpec

class HangoutsTestSuite extends FlatSpec with SharedSparkContext with RDDComparisons {

    "Hangouts processor" should "filter, parse, and add sentence boundaries an example Google Hangouts file" in {
        val inputFilename = System.getProperty( "user.dir" ) + "/ngram-extractor/src/test/resources/data/input/hangouts-sample.txt"
        val outputFilename = System.getProperty( "user.dir" ) + "/ngram-extractor/src/test/resources/data/output/hangouts-sample-expected.txt"

        val data = sc.textFile( inputFilename )
        val hangouts : Hangouts = new Hangouts( Some( "Michael Reynolds" ) )
        val actual : RDD[ String ] = hangouts.lines( data )

        val expected : RDD[ String ] = sc.textFile( outputFilename )

        assertRDDEquals( expected, actual )
    }

    "Hangouts processor" should "produce an accurate token count" in {
        val inputFilename = System.getProperty( "user.dir" ) + "/ngram-extractor/src/test/resources/data/input/hangouts-sample.txt"

        val data = sc.textFile( inputFilename )
        val hangouts : Hangouts = new Hangouts( Some( "Michael Reynolds" ) )
        val actual : Long = hangouts.tokenCount( data )

        val expectedCount : Long = 66L
        assert( expectedCount == actual )
    }
}