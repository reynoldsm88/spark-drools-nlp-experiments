package org.reynoldsm88.nlp.model.morph

import java.util.{ArrayList => JArrayList}

import scala.util.Random


case class Sentence( id : Long, text : String ) {

    def tokenize( ) : List[ Token ] = text.split( " " ).map( t => Token( Random.nextLong, t, new JArrayList[ PosTag ]() ) ).toList

}