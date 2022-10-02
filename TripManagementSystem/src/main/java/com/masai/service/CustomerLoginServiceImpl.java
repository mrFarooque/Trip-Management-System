package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.models.CurrentCustomerSession;
import com.masai.models.Customer;
import com.masai.models.CustomerDTO;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDAO;
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
	@Autowired private CustomerDao CustomerDao;
	@Autowired private CustomerSessionDAO CustomerSessionDAO;

	@Override
	public String logIntoAccount(CustomerDTO customerDTO) {
		Optional<Customer> opt= CustomerDao.findByMobile(customerDTO.getMobile());

		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}

		Customer customer1= opt.get();
		Integer userId = customer1.getCustomerId();
		Optional<CurrentCustomerSession>  currUseropt1= CustomerSessionDAO.findByUserId(userId);

		if(currUseropt1.isPresent()) {
			return "User already logged in with this number.";
		}

		if(customer1.getPassword().equals(customerDTO.getPassword())) {

			String key = RandomString.getRandomNumberString();
			CurrentCustomerSession currentUserSession = new CurrentCustomerSession(userId, key, LocalDateTime.now());

			CustomerSessionDAO.save(currentUserSession);


			return currentUserSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}


	}



	@Override
	public String logOutAccount(String key) {
		Optional<CurrentCustomerSession> currUserOpt=CustomerSessionDAO.findByUuid(key);

		if(currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1=currUserOpt.get();

			CustomerSessionDAO.delete(currUser1);
			return "User logged out successfully.";
		}
		return "User does not exist, Enter correct uuid";

	}
	
	@Override
	public boolean isLoggedIn(Integer customerId) throws LoginException {
		Optional<CurrentCustomerSession> opt = CustomerSessionDAO.findByUserId(customerId);
		if(opt.isPresent()) return true;
		else throw new LoginException("LogIn first !! ");
	}



	@Override
	public boolean isLoggedInByUUID(String uuid) throws LoginException {
		Optional<CurrentCustomerSession> opt = CustomerSessionDAO.findByUuid(uuid);
		if(opt.isPresent()) return true;
		else throw new LoginException("LogIn first !! ");
	}
	
	


}
