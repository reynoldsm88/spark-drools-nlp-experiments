package org.reynoldsm88.hdfs.ingest

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.reynoldsm88.hdfs.utils.HDFS

object HdfsImport {

    def main( args : Array[ String ] ) : Unit = {
        val hadoop : HDFS = {
            val hdfsConfig = new Configuration()
            hdfsConfig.set( "fs.defaultFS", "hdfs://<PUT_IP_HERE>:9000" )
            val fileSystem = FileSystem.get( hdfsConfig )
            new HDFS( fileSystem )
        }

        val content = "Hello world!"
        hadoop.write( "/etc/hadoop/hdfs/test.txt", List( content ) )
        hadoop.cat( "/etc/hadoop/hdfs/test.txt" )
    }

}