package org.reynoldsm88.ngram.extractor

import org.apache.spark.{SparkConf, SparkContext}

object NgramExtractor {

    def main( args : Array[ String ] ) : Unit = {
        val conf : SparkConf = new SparkConf().setAppName( "ngram-extractor" )
        val sc : SparkContext = new SparkContext( conf )
        println( "Hello World!" )
    }

}