package ignite.service

import org.apache.ignite.Ignite
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClusterService {

    @Autowired
    Ignite ignite

    void broadcastHelloWorld() {
        ignite.compute().broadcast(new HelloWorldJob(ignite: ignite))
    }
}
