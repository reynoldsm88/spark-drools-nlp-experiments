import org.kie.api.KieServices
import org.scalatest.FlatSpec


class FrenchNounsPOSTaggingTestSuite extends FlatSpec {


    "Placeholder rules" should "fire one rule for now" in {
        val ksession = KieServices.Factory.get.newKieClasspathContainer().newKieSession( "ngram-ksession" )
        ksession.insert( "Hello world!" )
        val rulesFired = ksession.fireAllRules()
        assert( rulesFired == 1 )

        // TODO - saving this because this code is annoying to remember
        //        val i = ksession.getObjects( new ClassObjectFilter( classOf[ BiGram ] ) ).iterator()

        //        val resultsBuffer = ListBuffer[ BiGram ]()
        //        while ( i.hasNext ) {
        //            resultsBuffer += i.next().asInstanceOf[ BiGram ]
        //        }

    }
}