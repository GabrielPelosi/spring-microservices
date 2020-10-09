package com.gabriel.person.service.serviceImpl;

import com.gabriel.person.repository.PersonRepository;
import com.gabriel.person.repository.entity.Person;
import com.gabriel.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Optional<Person> updatePerson(Person person) {
        return personRepository.findById(person.getId())
                .map(p -> person)
                .map(personRepository::save);
    }

    @Override
    public Optional<Boolean> deletePersonById(Long id) {
        return personRepository.findById(id)
                .map(person -> {
                    personRepository.delete(person);
                    return true;
                });
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}
