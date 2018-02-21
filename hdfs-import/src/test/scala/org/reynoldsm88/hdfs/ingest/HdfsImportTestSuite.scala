package org.reynoldsm88.hdfs.ingest

import org.scalatest.FlatSpec
import scala.io.Source

class HdfsImportTestSuite extends FlatSpec with HdfsMiniCluster {

    "The HDFS import job" should "produce results that match the hdfs-minimal.txt file" in {
        val lines = Source.fromInputStream( getClass.getClassLoader.getResourceAsStream( "data/hdfs-minimal.txt" ) ).getLines().toList
        hdfs.write( "/etc/test/data.txt", lines )
        val hdfsFile : List[ String ] = hdfs.readAsText( "/etc/test/data.txt" )
        assert( lines == hdfsFile )
    }
}