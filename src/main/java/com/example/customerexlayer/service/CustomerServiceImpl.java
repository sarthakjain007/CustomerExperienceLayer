package com.example.customerexlayer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.customerexlayer.dto.CustomerDTO;
import com.example.customerexlayer.dto.CustomerInputDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	WebClient client = WebClient.create("http://localhost:8080");

	@Override
	public Flux<CustomerDTO> getCustomers() {
		return client.get().uri("/v1/customers/details").retrieve().bodyToFlux(CustomerDTO.class);
	}

	@Override
	public Mono<CustomerDTO> createCustomer(CustomerInputDTO customerInputDTO) {
		return client.post().uri("/v1/customers/create").body(Mono.just(customerInputDTO),CustomerInputDTO.class).retrieve().bodyToMono(CustomerDTO.class);
	}

	@Override
	public Flux<CustomerDTO> getFirstNCustomers(int limit) {
		return client.get().uri("/v1/customers/limit/{limit}", limit).retrieve().bodyToFlux(CustomerDTO.class);
	}

	@Override
	public Mono<CustomerDTO> getCustomer(int customerId) {
		return client.get().uri("/v1/customers/{customerId}", customerId).retrieve().bodyToMono(CustomerDTO.class);
	}
}
