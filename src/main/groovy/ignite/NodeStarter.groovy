package ignite

import ignite.conf.IgniteContext
import org.apache.ignite.Ignition
import org.apache.ignite.configuration.IgniteConfiguration
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class NodeStarter {

    static void main(def args) {
        def context = new AnnotationConfigApplicationContext(IgniteContext)
        def conf = context.getBean(IgniteConfiguration)

        Ignition.start conf
    }
}
