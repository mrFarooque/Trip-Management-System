package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Admin;
import com.masai.models.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDAO;

@Service
public class AdminServiceImpl implements AdminService{ 
	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private AdminSessionDAO adminSessionDAO;
	@Override
	public Admin createAdmin(Admin admin) {
		Optional<Admin> opt= adminDao.findByMobileNo(admin.getMobile());
		
		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return adminDao.save(admin);
	}
}


