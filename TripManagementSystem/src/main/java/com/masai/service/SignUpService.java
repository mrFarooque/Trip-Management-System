package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.models.SignUp;

public interface SignUpService {
	
	public SignUp createNewSignUp(SignUp signUp) throws LoginException;;
	
	public SignUp updateSignUpDetails(SignUp signUp,String key) throws LoginException;;

}
