package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exceptions.UserException;
import com.masai.models.User;
import com.masai.repository.AdminSessionDAO;
import com.masai.repository.CustomerSessionDAO;
import com.masai.repository.UserDao;

public class UserServiceImpl implements UserService {
@Autowired
UserDao dao;
@Autowired
private AdminSessionDAO adminSessionDAO;

@Autowired
private CustomerSessionDAO customerSessionDAO;
	@Override
	public User getUserById(Integer idcardid, String key) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
