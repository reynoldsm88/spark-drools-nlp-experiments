package org.reynoldsm88.ngram.extractor

import com.owlike.genson.defaultGenson._
import org.apache.spark.{SparkConf, SparkContext}
import org.reynoldsm88.ngram.extractor.config.JobConfig

import scala.io.Source

object Main {

    def main( args : Array[ String ] ) : Unit = {
        val conf = new SparkConf().setAppName( "ngram-extractor" )
        val spark = new SparkContext( conf )

        val jobConfig = fromJson[ JobConfig ]( Source.fromFile( args( 0 ) ).mkString )
        println( jobConfig )

        new NgramExtractor( jobConfig, spark ).run()

        spark.stop()
    }

}