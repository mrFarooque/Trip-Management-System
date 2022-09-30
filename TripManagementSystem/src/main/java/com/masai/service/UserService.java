package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exceptions.UserException;
import com.masai.models.User;

@Service
public interface UserService {
	public User getUserById(Integer idcardid,String key) throws UserException;
	
}
