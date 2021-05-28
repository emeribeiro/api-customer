package com.example.api.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.form.CustomerAddressForm;
import com.example.api.service.CustomerAddressService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/customerAddress")
public class CustomerAddressController {
	
	@Autowired
    private CustomerAddressService customerService;

    @PostMapping("/{customerId}")
    public void incluir(@PathVariable Long customerId, @RequestBody CustomerAddressForm form) throws NotFoundException { 
    	customerService.incluir(customerId, form);
    }
    

	
}
