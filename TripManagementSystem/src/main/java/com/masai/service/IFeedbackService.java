package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.models.Feedback;

@Service
public interface IFeedbackService {
	public Feedback addFeedback(Feedback feedback, Integer id)throws CustomerException;
	public Feedback findByFeedbackId(Integer id)throws FeedbackException;
	public List<Feedback> findByCustomerId(Integer id)throws FeedbackException, CustomerException;
	public List<Feedback> viewAllFeedback() throws FeedbackException;
}