package org.reynoldsm88.ngram.sources

import org.apache.spark.rdd.RDD

class Plaintext extends TextSource {

    override def lines( data : RDD[ String ] ) : RDD[ String ] = {
        data
    }
}
