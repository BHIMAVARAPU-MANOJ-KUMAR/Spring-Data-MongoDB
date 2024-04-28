package com.springdatamongo.datamongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdatamongo.datamongo.model.PersonModel;

public interface PersonRepository extends MongoRepository<PersonModel, String>{
	Optional<PersonModel> findPersonModelByEmail(String email);
}
