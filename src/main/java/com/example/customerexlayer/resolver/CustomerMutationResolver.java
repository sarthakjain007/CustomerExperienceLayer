package com.example.customerexlayer.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.customerexlayer.dto.CustomerDTO;
import com.example.customerexlayer.dto.CustomerInputDTO;
import com.example.customerexlayer.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

import reactor.core.publisher.Mono;

@DgsComponent
public class CustomerMutationResolver {

	@Autowired
	CustomerService customerService;

	@DgsMutation
	public Mono<CustomerDTO> createCustomer(
			@InputArgument CustomerInputDTO customerInputDTO) {
		return customerService.createCustomer(customerInputDTO);
	}

}