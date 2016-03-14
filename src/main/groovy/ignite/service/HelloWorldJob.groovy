package ignite.service

import org.apache.ignite.Ignite
import org.apache.ignite.lang.IgniteRunnable
import org.apache.ignite.resources.IgniteInstanceResource

class HelloWorldJob implements IgniteRunnable {

    @IgniteInstanceResource
    Ignite ignite

    @Override
    void run() {
        println "First user balance: ${ignite.getOrCreateCache("person").get(1l).balance}"
    }
}
