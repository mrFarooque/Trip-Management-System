package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.models.LoginData;
public interface LoginService {
	
	public String logInAccount(LoginData loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;

}
