package com.example.api.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

public class CustomerForm {
	
	@NotNull
	@NotEmpty
	private String 	name;
	@NotNull
	@NotEmpty
	@Email
	private String 	email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer converter() {
		return new Customer(name, email);
	}
	public Customer update(Long id, CustomerService service) {
		Customer customer = service.getOne(id);
		customer.setName(this.name);
		customer.setEmail(this.email);
		return customer;
	}
	
	
}
