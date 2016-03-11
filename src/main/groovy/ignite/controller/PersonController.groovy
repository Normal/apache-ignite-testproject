package ignite.controller

import groovy.util.logging.Slf4j
import ignite.model.Person
import ignite.repository.PersonRepository
import ignite.server.ClusterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = "/person", method = RequestMethod.GET)
@Slf4j
class PersonController {

    @Autowired
    PersonRepository personRepository

    @Autowired
    ClusterService clusterService

    @RequestMapping("/all")
    List<Person> all() {
        personRepository.all()
    }

    @RequestMapping("/hello")
    String broadcast() {
        clusterService.broadcastHelloWorld()
        "passed!"
    }
}
