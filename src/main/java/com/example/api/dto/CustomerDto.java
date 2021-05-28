package com.example.api.dto;

import org.springframework.data.domain.Page;

import com.example.api.domain.Customer;

public class CustomerDto {

	private Long 	id;
	private String 	name;
	private String 	email;
	
	public CustomerDto (Customer customer) {
		this.id 	= customer.getId();
		this.name 	= customer.getName();
		this.email 	= customer.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public static Page<CustomerDto> converter(Page<Customer> customer) {
		return customer.map(CustomerDto::new);
	}

}
