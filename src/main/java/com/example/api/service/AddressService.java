package com.example.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.api.domain.Address;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface AddressService {
	
	@GetMapping("{cep}/json")
    Address buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
