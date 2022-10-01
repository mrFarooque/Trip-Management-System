package com.masai.service;



import java.util.List;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.PackageException;
import com.masai.models.Booking;
import com.masai.models.BookingDTO;

public interface IBookingService {

	
	public Booking createBooking(BookingDTO bookingDTO,Integer customerId)throws PackageException,CustomerException;
	public Booking cancelBooking(int bookingId)throws BookingException;
	public Booking viewBooking(int bookingId)throws BookingException;
	public List<Booking> viewAllBooking()throws BookingException ;
	
}
