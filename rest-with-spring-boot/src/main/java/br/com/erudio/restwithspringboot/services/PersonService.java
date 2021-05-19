package br.com.erudio.restwithspringboot.services;

import br.com.erudio.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();


    public Person create(Person person){
        return person;
    }

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirsName("Teste");
        person.setLastName("Sobrenome");
        person.setAddress("Rua do teste 2");
        person.setGender("F");
        return person;
    }

    public List<Person> findAll(){

        List<Person> persons = new ArrayList<>();

        for(int i = 0; i < 8; ++i) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirsName("Pessoa " + i);
        person.setLastName("Sobrenome da pessoa " + i);
        person.setAddress("Rua do teste " + i);
        person.setGender("F");
        return person;
    }
}
