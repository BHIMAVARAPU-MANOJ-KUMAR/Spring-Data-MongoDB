package com.springdatamongo.datamongo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.springdatamongo.datamongo.enums.Gender;

import lombok.Data;

@Data
@Document(collection = "persondata")
public class PersonModel {
	
	@MongoId
	private String _id;
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String email;
	private Gender gender;
	private Address address;
	private List<String> favouriteSubjects;
	private BigDecimal totalMoneySpentOnBooks;
	private LocalDateTime created;
	
	public PersonModel(String firstName, 
						String lastName, 
						String email, 
						Gender gender, 
						Address address,
						List<String> favouriteSubjects, 
						BigDecimal totalMoneySpentOnBooks, 
						LocalDateTime created) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.favouriteSubjects = favouriteSubjects;
		this.totalMoneySpentOnBooks = totalMoneySpentOnBooks;
		this.created = created;
	}
	
}
