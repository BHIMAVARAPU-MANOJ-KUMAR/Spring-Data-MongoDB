package com.springdatamongo.datamongo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.springdatamongo.datamongo.enums.Country;
import com.springdatamongo.datamongo.enums.Gender;
import com.springdatamongo.datamongo.model.Address;
import com.springdatamongo.datamongo.model.PersonModel;
import com.springdatamongo.datamongo.repository.PersonRepository;

@SpringBootApplication
public class SpringBootDemoProjectSpringDataMongoDbApplication {
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoProjectSpringDataMongoDbApplication.class, args);
		
		/**
		 * COLLECTIONS --> Mongo Stores documents (Rows) in collections (Table)
		 */
	}
	
	@Bean
	CommandLineRunner commandLineRunner(PersonRepository personRepository,
			MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(Country.USA,"Austin", "73301");
			String email = "manojreddy@gmail.com";
			PersonModel model = new PersonModel(
					"Manoj",
					"Reddy",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science", "Project Management", "Cyber Security"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			personRepository.findPersonModelByEmail(email).ifPresentOrElse(s-> {
				System.out.println(s + " already Exists.");
			}, ()-> {
				System.out.println("Inserting Student " + model);
				personRepository.insert(model);
			});
		};
	}
}