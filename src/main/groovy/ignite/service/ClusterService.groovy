package ignite.service

import ignite.model.Person
import ignite.repository.PersonRepository
import org.apache.ignite.Ignite
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class ClusterService {

    @Autowired
    Ignite ignite

    @Autowired
    PersonRepository repository

    @PostConstruct
    void init() {
        def personMap = [:]

        repository.all().each {
            personMap.put(it.id, it)
        }

        ignite.cache("person").putAll(personMap)
    }

    List<Collection<Person>> cachedData() {
        ignite.compute().broadcast(new GetCacheDataJob())
    }
}
