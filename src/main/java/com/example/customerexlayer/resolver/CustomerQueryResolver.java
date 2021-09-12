package com.example.customerexlayer.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.customerexlayer.dto.CustomerDTO;
import com.example.customerexlayer.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@DgsComponent
public class CustomerQueryResolver {

	@Autowired
	CustomerService customerService;

	@DgsQuery
	public Mono<CustomerDTO> customerById(@InputArgument int customerId) {

		return customerService.getCustomer(customerId);
	}

	@DgsQuery
	public Flux<CustomerDTO> firstNCustomers(@InputArgument Integer limit) {

		return customerService.getFirstNCustomers(limit);
	}

	@DgsQuery
	public Flux<CustomerDTO> customerDetails() {

		return customerService.getCustomers();
	}

}
