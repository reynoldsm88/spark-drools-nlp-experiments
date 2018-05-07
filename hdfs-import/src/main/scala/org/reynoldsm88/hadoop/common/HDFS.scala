package org.reynoldsm88.hadoop.common

import java.io.OutputStreamWriter

import org.apache.hadoop.fs.{FileSystem, Path}

import scala.io.Source

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class HDFS( fileSystem : FileSystem ) {


    // see usage of FSDataOutputStream
    def write( filename : String, content : List[ String ] ) : Unit = ???
    def ls( path : String ) : List[ String ] = ???

    def rm( path : String, recursive : Boolean ) : Unit = ???

    def readAsText( filename : String ) : List[ String ] = ???

    def cat( filename : String ) : Unit = ???
}