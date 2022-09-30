package com.masai.service;



import com.masai.models.Customer;



public interface CustomerService {
	
public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer, String key);

}
