package ignite.repository

import ignite.model.Person
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    List<Person> all() {
        em.createQuery("from Person", Person.class).resultList
    }

    @Transactional
    Person get(Long id) {
        em.find(Person, id)
    }

    @Transactional
    void save(Person person) {
        em.persist(person)
    }

    @Transactional
    void delete(Long id) {
        em.remove(get(id))
    }
}
