package com.gabriel.person.service;

import com.gabriel.person.repository.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> findAllPersons();

    Optional<Person> findPersonById(Long id);

    Optional<Person> updatePerson(Person person);

    Optional<Boolean> deletePersonById(Long id);

    Person createPerson(Person person);
}
