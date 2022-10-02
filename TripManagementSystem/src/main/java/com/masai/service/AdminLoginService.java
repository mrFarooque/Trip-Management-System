package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.models.AdminDTO;

public interface AdminLoginService {
	public String logIntoAccount(AdminDTO adminDTO);
	public String logOutAccount(String key);
	public boolean isLoggedIn(Integer adminId) throws LoginException ;
	public boolean isLoggedInByUUID(String uuid) throws LoginException ;
}
