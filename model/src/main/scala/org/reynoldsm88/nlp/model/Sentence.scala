package org.reynoldsm88.nlp.model

import java.util.{UUID, List => JList}

import scala.beans.BeanInfo
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

@BeanInfo
case class Sentence( id : String, text : String ) {

    def biGrams( ) : JList[ BiGramOccurrence ] = {
        biGramsScala().asJava
    }

    def biGramsScala( ) : List[ BiGramOccurrence ] = {
        def gramSize = 2

        val tokens : List[ String ] = text.split( " " ).toList
        val bigrams : ListBuffer[ BiGramOccurrence ] = new ListBuffer[ BiGramOccurrence ]()

        for ( i <- 0 until ( tokens.size - gramSize ) ) {
            val root = tokens.slice( i, i + gramSize ).mkString( " " )
            val stem = tokens( i + gramSize )
            bigrams += BiGramOccurrence( root, stem )
        }

        bigrams.toList
    }
}