package ignite.repository

import ignite.model.Person
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    List<Person> all() {
        em.createQuery("from Person", Person.class).resultList
    }
}
