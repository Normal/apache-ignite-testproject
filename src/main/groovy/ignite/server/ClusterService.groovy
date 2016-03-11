package ignite.server

import org.apache.ignite.Ignite
import org.apache.ignite.lang.IgniteRunnable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClusterService {

    @Autowired
    Ignite ignite

    void broadcastHelloWorld() {
        ignite.compute().broadcast({
            some ->
                println "Hello World"
        } as IgniteRunnable)
    }
}
