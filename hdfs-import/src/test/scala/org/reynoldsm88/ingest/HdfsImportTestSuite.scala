package org.reynoldsm88.ingest

import java.io.File

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.hdfs.MiniDFSCluster
import org.apache.hadoop.test.PathUtils
import org.reynoldsm88.hadoop.common.HDFS
import org.scalatest.{BeforeAndAfterAll, FlatSpec}

import scala.io.Source

class HdfsImportTestSuite extends FlatSpec with BeforeAndAfterAll {


    var miniCluster : MiniDFSCluster = null
    var hdfs : HDFS = null

    val testDataPath : File = new File( PathUtils.getTestDir( getClass ), "minicluster" )

    System.clearProperty( MiniDFSCluster.PROP_TEST_BUILD_DATA )

    val conf : Configuration = {
        val conf = new Configuration()
        val testDataCluster = new File( testDataPath, "cluster1" )
        val clusterOnePath = testDataCluster.getAbsolutePath
        conf.set( "fs.defaultFS", "hdfs://localhost:9000" )
        conf.set( MiniDFSCluster.HDFS_MINIDFS_BASEDIR, clusterOnePath )
        conf
    }

    override def beforeAll( ) : Unit = {
        miniCluster = new MiniDFSCluster.Builder( conf ).nameNodePort( 9000 ).build()
        hdfs = new HDFS( FileSystem.get( conf ) )
    }

    override def afterAll( ) : Unit = {
        miniCluster.shutdown( true )
    }

    "The HDFS import job" should "produce results that match the hdfs-minimal.txt file" in {
        val lines = Source.fromInputStream( getClass.getClassLoader.getResourceAsStream( "data/hdfs-minimal.txt" ) ).getLines().toList
        hdfs.write( "/etc/test/data.txt", lines )
        val hdfsFile : List[ String ] = hdfs.readAsText( "/etc/test/data.txt" )
        assert( lines == hdfsFile )
    }
}