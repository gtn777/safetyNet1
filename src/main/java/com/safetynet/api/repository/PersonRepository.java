package com.safetynet.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.api.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByFirstNameAndLastName(String firstName, String lastName);

	void deleteByFirstNameAndLastName(String firstName, String lastName);

}
