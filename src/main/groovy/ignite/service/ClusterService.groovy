package ignite.service

import ignite.model.Person
import org.apache.ignite.Ignite
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClusterService {

    @Autowired
    Ignite ignite

    List<Collection<Person>> cachedData() {
        ignite.compute().broadcast(new GetCacheDataJob())
    }
}
