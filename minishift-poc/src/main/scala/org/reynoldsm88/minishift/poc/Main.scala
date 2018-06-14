package org.reynoldsm88.minishift.poc

import javax.servlet.ServletContext
import org.apache.spark.SparkContext
import org.scalatra.LifeCycle

object Main extends LifeCycle {

    override def init( context : ServletContext ) {
        //        context.mount()
    }

}
