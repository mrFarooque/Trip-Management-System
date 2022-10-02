package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Customer;
import com.masai.models.CustomerSigninDTO;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@PostMapping("/")
	public Customer saveCustomer(@RequestBody CustomerSigninDTO customer) {
		return customerService.createCustomer(customer);
	}

	// to update customer by passing key
	@PutMapping("/update")
	public Customer updateAdmin(@RequestBody CustomerSigninDTO customer, @RequestParam(required = false) String key) {

		return customerService.updateCustomer(customer, key);
	}
}
