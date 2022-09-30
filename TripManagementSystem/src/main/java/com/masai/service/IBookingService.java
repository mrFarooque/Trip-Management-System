package com.masai.service;



import java.util.List;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.PackageException;
import com.masai.models.Booking;

public interface IBookingService {

	
	public Booking makeBooking(Booking bookingDetail)throws PackageException;
	public Booking cancelBooking(int bookingId)throws BookingException;
	public Booking viewBooking(int bookingId)throws BookingException;
	public List<Booking> viewAllBooking()throws BookingException ;
	
}
