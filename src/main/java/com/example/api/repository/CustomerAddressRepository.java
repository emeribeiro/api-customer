package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.domain.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {


}
