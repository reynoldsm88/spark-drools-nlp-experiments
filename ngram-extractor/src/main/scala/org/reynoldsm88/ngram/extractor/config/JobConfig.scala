package org.reynoldsm88.ngram.extractor.config

case class SourceDescriptor( uri : String, resourceType : String, metadata : Map[ String, String ] )

case class RulesDescriptor( group : String, artifact : String, version : String )

case class JobConfig( name : String, rules : RulesDescriptor, sources : List[ SourceDescriptor ] )