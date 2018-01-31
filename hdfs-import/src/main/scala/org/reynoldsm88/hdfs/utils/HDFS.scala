package org.reynoldsm88.hdfs.utils

import java.io.OutputStreamWriter

import org.apache.hadoop.fs.{FileSystem, Path}

import scala.io.Source

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class HDFS( fileSystem : FileSystem ) {

    def write( filename : String, content : List[ String ] ) : Unit = {
        println( "writing file : " + filename )
        val path = new Path( filename )
        val out = new OutputStreamWriter( fileSystem.create( path, false ) )
        content.foreach( str => out.write( str + "\n" ) )
        out.flush()
        out.close()
    }

    def ls( path : String ) : List[ String ] = {
        // TODO implement me
        List()
    }

    def rm( path : String, recursive : Boolean ) : Unit = {
        //TODO - delete file
    }

    def readAsText( filename : String ) : List[ String ] = Source.fromInputStream( fileSystem.open( new Path( filename ) ) ).getLines.toList

    def cat( filename : String ) : Unit = readAsText( filename ).foreach( println )
}