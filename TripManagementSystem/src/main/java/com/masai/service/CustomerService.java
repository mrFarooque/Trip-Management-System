package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.models.Customer;
import com.masai.models.CustomerDTO;



public interface CustomerService {
	
	public Customer createCustomer(CustomerDTO customer);
	
	public Customer updateUser(Customer customer, String key);

}
