package com.springdatamongo.datamongo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdatamongo.datamongo.model.PersonModel;
import com.springdatamongo.datamongo.repository.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonService {

	private PersonRepository personRepository;
	
	public List<PersonModel> getAllPersons(){
		return personRepository.findAll();
	}
}
