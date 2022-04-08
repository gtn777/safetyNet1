package com.safetynet.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.api.model.Person;
import com.safetynet.api.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/persons")
	public Iterable<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@PostMapping("/person")
	public void createPerson(@RequestBody Person person) {
		personService.createPerson(person);
	}

	@PutMapping("/person")
	public void updatePerson(@RequestBody Person personUpdated) {
		personService.updatePerson(personUpdated);
	}

	@DeleteMapping("/person")
	public void deletePersonByFirstNameAndLastName(@RequestBody Map<String, String> personMap) {
		personService.deletePersonByFirstNameAndLastName(personMap.get("firstName"), personMap.get("lastName"));
	}

	@GetMapping("/person")
	public Iterable<Person> getPersonByFirstNameAndLastName(@RequestBody Map<String, String> personMap) {
		return personService.getPersonByFistNameAndLastName(personMap.get("firstName"), personMap.get("lastName"));
	}
}
