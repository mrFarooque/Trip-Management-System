package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.models.CurrentUserSession;
import com.masai.models.SignUp;

public interface CurrentUserSessionService {
	
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException;;
	public Integer getCurrentUserSessionId(String key) throws LoginException;;
	
	public SignUp getSignUpDetails(String key) throws LoginException;;
	

}
