package ignite.service

import ignite.model.Person
import org.apache.ignite.Ignite
import org.apache.ignite.lang.IgniteCallable
import org.apache.ignite.resources.IgniteInstanceResource

class GetCacheDataJob implements IgniteCallable<Collection<Person>> {

    @IgniteInstanceResource
    Ignite ignite

    @Override
    Collection<Person> call() throws Exception {
        def cache = ignite.getOrCreateCache("person")

        cache.getAll(1l .. 10l).values()
    }
}
