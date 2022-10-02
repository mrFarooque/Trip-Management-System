package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.models.Customer;
import com.masai.models.Feedback;
import com.masai.repository.CustomerDao;
import com.masai.repository.FeedbackDao;

@Service
public class FeedbackServiceImpl implements IFeedbackService{

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Feedback addFeedback(Feedback feedback, Integer id) throws CustomerException {
		Optional<Customer> customer = customerDao.findById(id);
		if(customer.isPresent()) {
			Customer previousCustomer = customer.get();
			List<Feedback> feedbackList = previousCustomer.getFeedbacks();
			feedbackList.add(feedback);
			customerDao.save(previousCustomer);
			return feedback;
		}else {
			throw new CustomerException("Customer not found with id : "+id);
		}	
	}

	@Override
	public Feedback findByFeedbackId(Integer id) throws FeedbackException {
		Optional<Feedback> previousFeedback = feedbackDao.findById(id);
		if(previousFeedback.isPresent()) {
			return previousFeedback.get();
		}else {
			throw new FeedbackException("Feedback Not found with Id : "+id);
		}
	}

	@Override
	public List<Feedback> findByCustomerId(Integer id) throws FeedbackException, CustomerException {
		Optional<Customer> customer = customerDao.findById(id);
		if(customer.isPresent()) {
			Customer previousCustomer = customer.get();
			List<Feedback> feedbackList = previousCustomer.getFeedbacks();
			if(feedbackList.size()>0) {
				return feedbackList;
			}else {
				throw new FeedbackException("No Feedbacks found for the customer id : "+id);
			}
		}else {
			throw new CustomerException("Customer not found with id : "+id);
		}
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		List<Feedback> feedbackList = feedbackDao.findAll();
		if(feedbackList.size()>0) {
			return feedbackList;
		}else {
			throw new FeedbackException("No feedbacks found for now!");
		}
	}

}
