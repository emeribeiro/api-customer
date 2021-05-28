package com.example.api.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.Address;
import com.example.api.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
    private AddressService addressService;

    @GetMapping("/{cep}")
    public ResponseEntity<Address> getCep(@PathVariable String cep) {

    	Address address = addressService.buscaEnderecoPorCep(cep);

        return address != null ? ResponseEntity.ok().body(address) : ResponseEntity.notFound().build(); 
    }
	
}
