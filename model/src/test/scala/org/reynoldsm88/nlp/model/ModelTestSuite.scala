package org.reynoldsm88.nlp.model

import java.util.UUID


import org.scalatest.FlatSpec

class ModelTestSuite extends FlatSpec {

    "Sentences" should "produce accurate bigram instances" in {
        val example = "<s> this is my sentence </s>"
        val sentence = Sentence( UUID.randomUUID().toString, example )

        val expected = List( BiGramOccurrence( "<s> this", "is" ),
                             BiGramOccurrence( "this is", "my" ),
                             BiGramOccurrence( "is my", "sentence" ),
                             BiGramOccurrence( "my sentence", "</s>" )
                           )

        val actual = sentence.biGramsScala()
        assert( expected.exists( a => actual.exists( b => a.root == b.root && a.stem == b.stem ) ) )
    }

}
