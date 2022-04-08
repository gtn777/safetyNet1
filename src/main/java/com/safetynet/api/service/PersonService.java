package com.safetynet.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;

import lombok.Data;

@Data
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Iterable<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Transactional
	public void deletePersonByFirstNameAndLastName(String firstName, String lastName) {
		personRepository.deleteByFirstNameAndLastName(firstName, lastName);
	}

	public Person createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

	public List<Person> getPersonByFistNameAndLastName(String firstName, String lastName) {
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public Person updatePerson(Person p) {
		Person personToSave = personRepository.findByFirstNameAndLastName(p.getFirstName(), p.getLastName()).get(0);
		personToSave.setAddress(p.getAddress());
		personToSave.setCity(p.getCity());
		personToSave.setZip(p.getZip());
		personToSave.setPhone(p.getPhone());
		personToSave.setMail(p.getMail());
		personRepository.deleteById(personToSave.getId());
		return createPerson(personToSave);
	}
}
