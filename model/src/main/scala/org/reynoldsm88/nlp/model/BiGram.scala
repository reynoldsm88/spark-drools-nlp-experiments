package org.reynoldsm88.nlp.model

import scala.beans.BeanInfo

@BeanInfo
case class BiGram( root : String, stem : String, count : Long ) {}
