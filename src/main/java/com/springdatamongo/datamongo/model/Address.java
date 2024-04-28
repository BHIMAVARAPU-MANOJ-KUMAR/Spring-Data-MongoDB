package com.springdatamongo.datamongo.model;

import com.springdatamongo.datamongo.enums.Country;
import lombok.Data;

@Data
public class Address {
	private Country country;
	private String city;
	private String postCode;

	public Address(Country country, String city, String postCode) {
		this.country = country;
		this.city = city;
		this.postCode = postCode;
	}
}
