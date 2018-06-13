package org.reynoldsm88.nlp.model.morph

import org.scalatest.FlatSpec

import scala.util.Random

import scala.collection.JavaConverters._


class MorphModelTestSuite extends FlatSpec {

    "Sentence tokenization" should "produce the correct list of Tokens" in {
        val sentence : Sentence = Sentence( Random.nextLong, "This is my sentence" )
        val actual : List[ Token ] = sentence.tokenize()

        assert( actual.size == 4 )
        assert( actual( 0 ).value == "This" )
        assert( actual( 1 ).value == "is" )
        assert( actual( 2 ).value == "my" )
        assert( actual( 3 ).value == "sentence" )
    }

    "POS tagging" should "return a Token with the new set of potential tags" in {
        val original = Token( Random.nextLong, "foo", List[ PosTag ]().asJava )
        val tagged = original.addTag( PosTag( "NN------------" ) )

        assert( tagged.id == original.id )
        assert( tagged.value == original.value )
        assert( tagged.potentialTags.contains( PosTag( "NN------------" ) ) )
    }

}