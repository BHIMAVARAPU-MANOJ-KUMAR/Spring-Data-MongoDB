package com.springdatamongo.datamongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatamongo.datamongo.model.PersonModel;
import com.springdatamongo.datamongo.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/person")
@AllArgsConstructor
public class PersonController {

	private PersonService personService;
	
	@GetMapping
	public List<PersonModel> fetchAllPersons(){
		
		return personService.getAllPersons();
	}
}
