package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Admin;
import com.masai.models.AdminDTO;
import com.masai.models.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDAO;

@Service
public class AdminLogInServiceImpl implements AdminLoginService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDAO adminSessionDAO;

	@Override
	public String logIntoAccount(AdminDTO adminDTO) {
		Optional<Admin> opt= adminDao.findByMobile(adminDTO.getMobile());
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		Admin admin1= opt.get();
		Integer adminId = admin1.getUserId();
		Optional<CurrentAdminSession>  currAdminopt1= adminSessionDAO.findByAdminId(adminId);
		
		if(currAdminopt1.isPresent()) {
			return "Admin already logged in with this number.";
		}
		
		if(admin1.getPassword().equals(adminDTO.getPassword())) {
			
			String key = RandomString.getRandomNumberString();
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(adminId, key, LocalDateTime.now());
			
			adminSessionDAO.save(currentAdminSession);
			
			return currentAdminSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}
	}

	@Override
	public String logOutAccount(String key) {
Optional<CurrentAdminSession> currAdminOpt=adminSessionDAO.findByUuid(key);
		
		if(currAdminOpt.isPresent()) {
			CurrentAdminSession currAdmin1=currAdminOpt.get();
			
			adminSessionDAO.delete(currAdmin1);
			return "Admin logged out successfully.";
		}
		return "Admin does not exist, Enter correct uuid";
	}
	}


