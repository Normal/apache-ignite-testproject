package ignite.service

import ignite.model.Person
import ignite.repository.PersonRepository
import org.apache.ignite.cache.store.CacheStoreAdapter
import org.apache.ignite.resources.SpringResource

import javax.cache.Cache
import javax.cache.integration.CacheLoaderException
import javax.cache.integration.CacheWriterException

class PersonCacheAdapter extends CacheStoreAdapter<Long, Person> implements Serializable {

    @SpringResource(resourceName = "personRepository")
    transient PersonRepository personRepository

    @Override
    Person load(Long key) throws CacheLoaderException {
        personRepository.get(key)
    }

    @Override
    void write(Cache.Entry<? extends Long, ? extends Person> entry) throws CacheWriterException {
        entry.value.id  = entry.key
        personRepository.save(entry.value)
    }

    @Override
    void delete(Object key) throws CacheWriterException {
        personRepository.delete(key as Long)
    }
}
