package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.LoginData;
import com.masai.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LoginData loginData) throws LoginException {
		return loginService.logInAccount(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws LoginException
	{
		return loginService.logOutFromAccount(key);
	}
	

}
