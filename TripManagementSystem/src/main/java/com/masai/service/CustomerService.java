package com.masai.service;

import java.util.List;

import com.masai.models.Customer;
import com.masai.models.CustomerDTO;
import com.masai.models.CustomerSigninDTO;



public interface CustomerService {
//	Fmethod	
//	public Customer createCustomer(CustomerDTO customer);
	
	public Customer createCustomer(CustomerSigninDTO customersigninDto);
	public Customer updateUser(Customer customer, String key);
	public Customer updateCustomer(CustomerSigninDTO customersigninDto, String key);
	public List<Customer> allCustomer();

}
