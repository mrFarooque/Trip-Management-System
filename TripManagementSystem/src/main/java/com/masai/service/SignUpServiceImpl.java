package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.models.SignUp;
import com.masai.repository.SignUpDAO;


@Service
public class SignUpServiceImpl implements SignUpService {


	@Autowired
	private SignUpDAO signUpDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Override
	public SignUp createNewSignUp(SignUp newSignUp) {
		
		Optional<SignUp> opt = signUpDAO.findByUserName(newSignUp.getUserName());
		if(opt.isPresent())
		{
			throw new LoginException("User Already Exist!");
		}
		
		return signUpDAO.save(newSignUp);
	}

	@Override
	public SignUp updateSignUpDetails(SignUp signUp, String key) {
		
		SignUp signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LoginException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpDAO.save(signUp);
			return signUp;
			}
		else
			throw new LoginException("Can't change UserId!!");
	}

}
