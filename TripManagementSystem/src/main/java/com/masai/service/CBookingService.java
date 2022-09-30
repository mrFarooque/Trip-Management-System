package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Booking;
import com.masai.models.Package;
import com.masai.repository.BookingDao;
import com.masai.repository.PackageDao;

import net.bytebuddy.asm.Advice.Return;

@Service
public class CBookingService implements IBookingService{
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private PackageDao packageDao;

	@Override
	public Booking makeBooking(Booking bookingDetail) {
		for (Package package1 : bookingDetail.getPackages()) {
			Optional<Package> pOptional=packageDao.findById(package1.getPackageId());
			
			if (pOptional==null) {
				throw new PackageExcepion("This Package is not Available Right Now!!");
			}
		}
		bookingDao.save(bookingDetail);
	}

	@Override
	public Booking cancelBooking(int bookingId) {
		Optional<Booking> bOptional=bookingDao.findById(bookingId);
		if (bOptional==null) {
			throw new BookingException("No Such Booking exists to cancel");
		}
		bookingDao.delete(bOptional.get());
	}

	@Override
	public Booking viewBooking(int bookingId) {
		Optional<Booking> bOptional=bookingDao.findById(bookingId);
		if (bOptional==null) {
			throw new BookingException("No Such Booking exists to view");
		}
		return bOptional.get();
	}

	@Override
	public List<Booking> viewAllBooking() {
		List<Booking> bookings=bookingDao.findAll();
		if (bookings.isEmpty()) {
			throw new BookingException("No Booking is made till now");
		}
		return bookings;
	}

}
