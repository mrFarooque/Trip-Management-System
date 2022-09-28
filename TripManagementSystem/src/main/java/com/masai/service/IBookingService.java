package com.masai.service;



import java.util.List;

import com.masai.models.Booking;

public interface IBookingService {

	
	public Booking makeBooking(Booking bookingDetail);
	public Booking cancelBooking(int bookingId);
	public Booking viewBooking(int bookingId);
	public List<Booking> viewAllBooking();
	
}
