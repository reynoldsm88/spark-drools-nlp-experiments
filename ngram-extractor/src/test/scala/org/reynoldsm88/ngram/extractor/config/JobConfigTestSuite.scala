package org.reynoldsm88.ngram.extractor.config

import org.scalatest.FlatSpec
import com.owlike.genson.defaultGenson._

import scala.io.Source

class JobConfigTestSuite extends FlatSpec {

    "Job Config parsing" should "produce the equivalent job config from JSON file" in {
        val expectedConfig : JobConfig = {
            val metadata = Map( "username" -> "Michael Reynolds" )
            val rules = RulesDescriptor( "org.reynoldsm88", "ngram-rules", "0.0.1-SNAPSHOT" )
            val sources = List( SourceDescriptor( "hdfs://localhost:9000/etc/data/hangouts/chris-hangouts.txt", "hangouts", Map( "username" -> "Michael Reynolds" ) ) )
            JobConfig( "hangouts-ngram-extractor", rules, sources )
        }

        val jobConfigJson = Source.fromFile( System.getProperty( "user.dir" ) + "/ngram-extractor/src/test/resources/config/test-job-config.json" ).mkString
        val actualConfig = fromJson[ JobConfig ]( jobConfigJson )

        assert( expectedConfig == actualConfig )
    }

}
