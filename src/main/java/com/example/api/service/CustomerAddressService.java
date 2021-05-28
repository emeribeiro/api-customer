package com.example.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.domain.CustomerAddress;
import com.example.api.form.CustomerAddressForm;
import com.example.api.repository.CustomerAddressRepository;

import javassist.NotFoundException;

@Service
public class CustomerAddressService {

	@Autowired
    private CustomerService customerService;
	@Autowired
    private CustomerAddressRepository repository;

    public void incluir (Long customerId, CustomerAddressForm form) throws NotFoundException { 

    	Optional<Customer> customerOptional = customerService.findById(customerId);
    	
    	if(customerOptional.isPresent()) {
    		Customer customer = customerOptional.get();
    		CustomerAddress customerAddress = new CustomerAddress(form, customer);
    		repository.save(customerAddress);
    	} else {
    		throw new NotFoundException("Dados inválidos!");
    	}
    	
    	
    }

	

}
