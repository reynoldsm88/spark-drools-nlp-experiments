package org.reynoldsm88.nlp.model.morph

import java.util.{List => JList}

import scala.collection.JavaConverters._

case class Token( id : Long, value : String, potentialTags : JList[ PosTag ] ) {

    // want to have a scala list internally if there's a case where we want to use native scala operations
    // any list manipulation should happen on the internal object as converted to java publicly
    private val potentialTagsInternal : List[ PosTag ] = potentialTags.asScala.toList

    def addTag( tag : PosTag ) : Token = Token( id, value, ( potentialTagsInternal :+ tag ).asJava )

    def tags( ) : JList[ PosTag ] = potentialTagsInternal.asJava
}
