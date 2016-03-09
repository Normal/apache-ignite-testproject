package service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonService {

    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Grigory", 200, 27));
        persons.add(new Person("Dmitry", 150, 30));
        persons.add(new Person("Stepan", 100, 28));

        return persons;
    }
}
