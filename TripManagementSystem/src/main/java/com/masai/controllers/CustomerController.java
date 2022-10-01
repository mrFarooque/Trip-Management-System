package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.PackageException;
import com.masai.models.Booking;
import com.masai.models.BookingDTO;
import com.masai.models.Customer;
import com.masai.models.CustomerDTO;
import com.masai.service.CBookingService;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired CBookingService bookingService;
	
	@PostMapping("/")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customer){
		return new ResponseEntity<Customer>(customerService.createCustomer(customer),HttpStatus.OK);
	}
	
	@PostMapping("/booking/{id}")
	public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO,@PathVariable("id") Integer customerId) throws PackageException, CustomerException{
		Booking booking = bookingService.createBooking(bookingDTO, customerId);
		return new ResponseEntity<Booking>(booking,HttpStatus.CREATED);
	}
	
	
}
