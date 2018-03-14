package org.reynoldsm88.nlp.model

import java.util.UUID

import scala.beans.BeanInfo

@BeanInfo
case class BiGramOccurrence( root : String, stem : String ) {
    val id : String = UUID.randomUUID().toString
}
