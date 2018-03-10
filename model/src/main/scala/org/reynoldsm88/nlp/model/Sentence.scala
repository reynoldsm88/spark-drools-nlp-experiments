package org.reynoldsm88.nlp.model

import java.util.{UUID, List => JList}

import scala.beans.BeanInfo
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

@BeanInfo
case class Sentence( id : String, text : String ) {

    def biGrams( ) : JList[ BiGramInstance ] = {
        biGramsScala().asJava
    }

    def biGramsScala( ) : List[ BiGramInstance ] = {
        def gramSize = 2

        val tokens : List[ String ] = text.split( " " ).toList
        val bigrams : ListBuffer[ BiGramInstance ] = new ListBuffer[ BiGramInstance ]()

        for ( i <- 0 to ( tokens.size - gramSize - 1 ) ) {
            val root = tokens.slice( i, i + gramSize ).mkString( " " )
            val stem = tokens( i + gramSize )
            bigrams += BiGramInstance( UUID.randomUUID().toString, root, stem )
        }

        bigrams.toList
    }
}