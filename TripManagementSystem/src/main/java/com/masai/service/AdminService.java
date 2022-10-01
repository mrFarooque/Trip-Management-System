package com.masai.service;

import com.masai.models.Admin;

public interface AdminService {
public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin, String key);
}

