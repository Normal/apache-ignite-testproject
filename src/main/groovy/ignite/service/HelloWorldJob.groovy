package ignite.service

import org.apache.ignite.lang.IgniteRunnable

class HelloWorldJob implements IgniteRunnable {

    @Override
    void run() {
        println "Hello World2"
    }
}
