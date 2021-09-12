package com.example.customerexlayer.service;

import com.example.customerexlayer.dto.CustomerDTO;
import com.example.customerexlayer.dto.CustomerInputDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

	public Flux<CustomerDTO> getCustomers();

	public Mono<CustomerDTO> createCustomer(CustomerInputDTO customerInputDTO);

	public Flux<CustomerDTO> getFirstNCustomers(int limit);
	
	public Mono<CustomerDTO> getCustomer(int customerId);

}
