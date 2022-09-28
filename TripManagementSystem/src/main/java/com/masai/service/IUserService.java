package com.masai.service;

import com.masai.models.User;

public interface IUserService {

	
	public User addNewUser(User userDetails);
	public User signIn(User userDetails);
	public User signOut(User userDetails);
}
