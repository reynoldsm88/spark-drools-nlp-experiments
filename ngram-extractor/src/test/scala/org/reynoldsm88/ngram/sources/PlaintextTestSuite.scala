package org.reynoldsm88.ngram.sources

import com.squareup.okhttp.{OkHttpClient, Request, Response}
import org.scalatest.FlatSpec

class PlaintextTestSuite extends FlatSpec {

    "Plaintext resource type" should "be able to load from an http link" in {
        val testUrl = "https://raw.githubusercontent.com/reynoldsm88/spark-drools-nlp-experiments/a010319abd02a8d7c9d7bffd55a8aa03cce0f904/ngram-extractor/src/test/resources" +
                      "/data/input/trump_speech.txt"

        val httpClient : OkHttpClient = new OkHttpClient()
        val response : Response = httpClient.newCall( new Request.Builder().url( testUrl ).build() ).execute()

        println( new String( response.body.bytes ) )
    }
}
