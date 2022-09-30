package com.masai.service;

import com.masai.models.AdminDTO;

public interface AdminLoginService {
public String logIntoAccount(AdminDTO adminDTO);
	
	public String logOutAccount(String key);
}
