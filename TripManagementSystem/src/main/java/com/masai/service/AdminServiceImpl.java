package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Admin;
import com.masai.models.AdminSigninDTO;
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
	public Admin createAdmin(AdminSigninDTO adminsigninDto) {
		Optional<Admin> opt= adminDao.findByMobile(adminsigninDto.getMobile());
		 Admin admin = new Admin();
		 admin.setAdminName(adminsigninDto.getAdminName());
		 admin.setPassword(adminsigninDto.getPassword());
		 admin.setMobile(adminsigninDto.getMobile());
		 admin.setEmail(adminsigninDto.getEmail());
		 
		 admin.setUserType("admin");
		
		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(AdminSigninDTO adminsigninDto, String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Admin admin = new Admin();
		 admin.setAdminName(adminsigninDto.getAdminName());
		 admin.setPassword(adminsigninDto.getPassword());
		 admin.setMobile(adminsigninDto.getMobile());
		 admin.setEmail(adminsigninDto.getEmail());
		 
		 admin.setUserType("admin");
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return adminDao.save(admin);
	}
}


