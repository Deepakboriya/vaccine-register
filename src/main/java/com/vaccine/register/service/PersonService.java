package com.vaccine.register.service;

import com.vaccine.register.entity.Person;
import com.vaccine.register.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        return personRepository.saveAll(persons);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
