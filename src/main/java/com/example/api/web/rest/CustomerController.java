package com.example.api.web.rest;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.api.domain.Customer;
import com.example.api.dto.CustomerDto;
import com.example.api.form.CustomerForm;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	@Cacheable(value = "listCustomers")
	public Page<CustomerDto> findAll(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return CustomerDto.converter(service.findAll(page, size));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
		Optional<Customer> customer = service.findById(id);
		if (customer.isPresent()) {
			return ResponseEntity.ok(new CustomerDto(customer.get()));
		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listCustomers", allEntries = true)
	public ResponseEntity<CustomerDto> register(@RequestBody @Valid CustomerForm form, UriComponentsBuilder builder) {
		Customer customer = form.converter();
		service.save(customer);
		
		URI uri = builder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(uri).body(new CustomerDto(customer));
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listCustomers", allEntries = true)
	public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody @Valid CustomerForm form) {
		Optional<Customer> customerOptional = service.findById(id);
		if (customerOptional.isPresent()) {
			Customer customer = form.update(id, service);
			return ResponseEntity.ok(new CustomerDto(customer));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listCustomers", allEntries = true)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Customer> customerOptional = service.findById(id);
		if (customerOptional.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
