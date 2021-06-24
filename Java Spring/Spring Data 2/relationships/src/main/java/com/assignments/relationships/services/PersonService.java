package com.assignments.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.relationships.models.Person;
import com.assignments.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> allPersons() {
		return personRepository.findAll();
	}

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public Person findPerson(Long id) {
		Optional<Person> optionalPesron = personRepository.findById(id);
		if (optionalPesron.isPresent()) {
			return optionalPesron.get();
		} else {
			return null;
		}
	}
	public List<Person> unlicensePersons() {
        return personRepository.findByLicenseIdIsNull();
    }
}
