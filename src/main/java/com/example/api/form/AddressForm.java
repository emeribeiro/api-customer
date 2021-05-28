package com.example.api.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;

public class AddressForm {
	
	@NotNull
	@NotEmpty
	private String cep;
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Address converter() {
		return new Address(cep);
	}
    
}
