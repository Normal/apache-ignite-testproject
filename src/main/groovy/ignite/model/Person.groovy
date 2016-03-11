package ignite.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "persons")
class Person {

    @Id
    long id

    int type

    int balance
}
