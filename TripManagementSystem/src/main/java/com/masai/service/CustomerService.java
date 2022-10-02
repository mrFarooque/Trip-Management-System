package com.masai.service;



import com.masai.models.Customer;
import com.masai.models.CustomerSigninDTO;



public interface CustomerService {
	
public Customer createCustomer(CustomerSigninDTO customersigninDto);
	
	public Customer updateCustomer(CustomerSigninDTO customersigninDto, String key);

}
