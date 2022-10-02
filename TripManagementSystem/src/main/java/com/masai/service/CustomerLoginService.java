package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.models.CustomerDTO;

public interface CustomerLoginService {
	public String logIntoAccount(CustomerDTO customerDTO);
	public String logOutAccount(String key);
	public boolean isLoggedIn(Integer customerId) throws LoginException ;
	public boolean isLoggedInByUUID(String uuid) throws LoginException ;
}
