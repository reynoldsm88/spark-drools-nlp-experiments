package org.reynoldsm88.ngram.extractor

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

class NgramExtractor {
    val conf : SparkConf = new SparkConf().setAppName( "ngram-extractor" )
    val sc : SparkContext = new SparkContext( conf )

    val rawText : RDD[ String ] = sc.textFile( Conf.sourceUris( 0 ) )
    println( rawText.count() )
}
