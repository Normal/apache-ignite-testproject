package ignite.service

import ignite.model.Person
import ignite.repository.PersonRepository
import org.apache.ignite.Ignite
import org.apache.ignite.IgniteCache
import org.apache.ignite.IgniteException
import org.apache.ignite.lifecycle.LifecycleBean
import org.apache.ignite.lifecycle.LifecycleEventType
import org.apache.ignite.resources.IgniteInstanceResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CacheLoader implements LifecycleBean {

//    @Autowired
    @IgniteInstanceResource
    Ignite ignite

    @Autowired
    PersonRepository personRepository

    @Override
    void onLifecycleEvent(LifecycleEventType evt) throws IgniteException {

        if (evt == LifecycleEventType.AFTER_NODE_START) {
            IgniteCache<Long, Person> cache = ignite.cache("person")

            def persons = personRepository.all()

            persons.each {
                cache.put(it.id, it)
            }
        }

    }
}
