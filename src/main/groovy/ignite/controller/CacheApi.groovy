package ignite.controller

import groovy.util.logging.Slf4j
import ignite.model.Person
import ignite.repository.PersonRepository
import ignite.service.ClusterService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = "/api", method = RequestMethod.GET)
@Slf4j
class CacheApi {

    @Autowired
    PersonRepository personRepository

    @Autowired
    ClusterService clusterService

    @RequestMapping("/fromdb")
    List<Person> fromDb() {
        personRepository.all()
    }

    @RequestMapping("/fromcache")
    Map<Integer, Collection<Person>> fromCache() {
        def cached = clusterService.cachedData()
        def result = [:]

        cached.eachWithIndex {
            persons, index ->
                result.put(index + 1, persons)
        }

        result
    }
}
