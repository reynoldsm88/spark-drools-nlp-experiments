package org.reynoldsm88.ngram.extractor

import java.io.OutputStreamWriter

import org.apache.hadoop.conf.{Configuration => HadoopConfiguration}
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.{SparkConf, SparkContext}

object HdfsImport {

    def main( args : Array[ String ] ) : Unit = {
        // @michael - commented out because I will get to it later, I don't feel like having to re copy this code
        //        conf.set( "fs.defaultFS", "hdfs://localhost:9000" )
        //        val hadoop : FileSystem = {
        //            val hdfsConfig = new HadoopConfiguration()
        //            hdfsConfig.set( "fs.defaultFS", "hdfs://localhost:9000" )
        //            FileSystem.get( hdfsConfig )
        //        }
        //        val content = "Hello world!"
        //        val path : Path = new Path( "test.txt" )
        //        val out : OutputStreamWriter = new OutputStreamWriter( hadoop.create( path, false ) )
        //        out.write( content )
        //        out.flush()
        //        out.close()

        //        sc.textFile( "hdfs://localhost:9000/etc/data/test.txt" ).foreach( println )

    }

}