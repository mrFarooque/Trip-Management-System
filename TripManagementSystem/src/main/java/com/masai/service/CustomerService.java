package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.models.Customer;



public interface CustomerService {
	
public Customer createCustomer(Customer customer);
	
	public Customer updateUser(Customer customer, String key);

}
