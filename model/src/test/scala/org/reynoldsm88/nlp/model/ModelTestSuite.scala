package org.reynoldsm88.nlp.model

import java.util.UUID

import org.scalatest.FlatSpec

class ModelTestSuite extends FlatSpec {

    "Sentences" should "produce accurate bigrams" in {
        val example = "<s> this is my sentence </s>"
        val sentence = Sentence( UUID.randomUUID().toString, example )
        sentence.biGramsScala().foreach( println )
    }
}
