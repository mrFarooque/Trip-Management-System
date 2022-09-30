package com.masai.service;

import com.masai.models.CustomerDTO;

public interface CustomerLoginService {
public String logIntoAccount(CustomerDTO customerDTO);
	
	public String logOutAccount(String key);
}
