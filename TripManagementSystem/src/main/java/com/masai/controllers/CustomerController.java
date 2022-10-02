package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.exceptions.HotelException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.PackageException;
import com.masai.models.Booking;
import com.masai.models.BookingDTO;
import com.masai.models.Customer;
import com.masai.models.CustomerSigninDTO;
import com.masai.models.Feedback;
import com.masai.models.Packages;
import com.masai.service.CBookingService;
import com.masai.service.CustomerLoginService;
import com.masai.service.CustomerService;
import com.masai.service.IFeedbackService;
import com.masai.service.IPackageService;
import com.masai.service.IReportService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired CBookingService bookingService;
	@Autowired IFeedbackService feedbackService;
	@Autowired IReportService reportService;
	@Autowired CustomerLoginService customerLoginService;
	@Autowired IPackageService packageService;
	

//  Fmethod
//	@PostMapping("/")
//	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customer){
//		return new ResponseEntity<Customer>(customerService.createCustomer(customer),HttpStatus.OK);
//	}
	
	@PostMapping("/")
	public Customer saveCustomer(@Valid @RequestBody CustomerSigninDTO customer) {
		return customerService.createCustomer(customer);
	}

	// to update customer by passing key
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerSigninDTO customer, @RequestParam(required = false) String key) {
		customerLoginService.isLoggedInByUUID(key);
		return customerService.updateCustomer(customer, key);
	}

	@PostMapping("/booking/{customerId}")
	public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO,@PathVariable("customerId") Integer customerId) throws PackageException, CustomerException,HotelException{
		customerLoginService.isLoggedIn(customerId);
		Booking booking = bookingService.createBooking(bookingDTO, customerId);
		return new ResponseEntity<Booking>(booking,HttpStatus.CREATED);
	}

	@DeleteMapping("/booking/{customerId}/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("bookingId") int bookingId,@PathVariable("customerId") Integer customerId) throws BookingException{
		customerLoginService.isLoggedIn(customerId);
		Booking booking = bookingService.cancelBooking(bookingId,customerId);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}


	@PostMapping("/feedback/{id}")
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback, @PathVariable Integer id) throws FeedbackException, CustomerException{
		customerLoginService.isLoggedIn(id);
		Feedback savedFeedback = feedbackService.addFeedback(feedback, id);
		return new ResponseEntity<Feedback>(savedFeedback, HttpStatus.CREATED);	
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<List<Feedback>> getFeedbacks(@PathVariable Integer id) throws FeedbackException, CustomerException{
		List<Feedback> feedbackList = feedbackService.findByCustomerId(id);
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}
	
	@GetMapping("/packagesViewAll")
	public ResponseEntity<List<Packages>> viewAllPackages() throws PackageException{
		List<Packages> packages=packageService.viewAllPackage();
		return new ResponseEntity<List<Packages>>(packages,HttpStatus.OK);
	}
	
	@GetMapping("/packagesView{packageId}")
	public ResponseEntity<Packages> searchPackages(@PathVariable int packageId) throws PackageException{
		Packages packages=packageService.searchPackage(packageId);
		return new ResponseEntity<Packages>(packages,HttpStatus.OK);
	}


}
