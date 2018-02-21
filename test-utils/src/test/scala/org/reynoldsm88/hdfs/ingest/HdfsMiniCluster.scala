package org.reynoldsm88.hdfs.ingest

import java.io.File

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.hdfs.MiniDFSCluster
import org.apache.hadoop.test.PathUtils
import org.reynoldsm88.hdfs.common.HDFS

trait HdfsMiniCluster {

    val srcFilePath = ""
    val testDataPath : File = new File( PathUtils.getTestDir( getClass ), "miniclusters" )

    System.clearProperty( MiniDFSCluster.PROP_TEST_BUILD_DATA )

    val conf : Configuration = {
        val conf = new Configuration()
        val testDataCluster = new File( testDataPath, "cluster1" )
        val clusterOnePath = testDataCluster.getAbsolutePath
        conf.set( "fs.defaultFS", "hdfs://localhost:9000" )
        conf.set( MiniDFSCluster.HDFS_MINIDFS_BASEDIR, clusterOnePath )
        conf
    }

    val miniCluster : MiniDFSCluster = new MiniDFSCluster.Builder( conf ).nameNodePort( 9000 ).build()

    val hdfs : HDFS = new HDFS( FileSystem.get( conf ) )
}