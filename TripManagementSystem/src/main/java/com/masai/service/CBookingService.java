package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.PackageException;
import com.masai.models.Booking;
import com.masai.models.BookingDTO;
import com.masai.models.Customer;
import com.masai.models.Packages;
import com.masai.models.PaymentDetails;
import com.masai.models.TicketDetails;
import com.masai.models.User;
import com.masai.repository.BookingDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.PackageDao;

@Service
public class CBookingService implements IBookingService{

	@Autowired BookingDao bookingDao;
	@Autowired PackageDao packageDao;
	@Autowired CustomerDao customerDao;


	@Override
	public Booking createBooking(BookingDTO bookingDTO,Integer customerId) throws PackageException,CustomerException {
		Optional<Packages> opt = packageDao.findById(bookingDTO.getPackageId());
		Optional<Customer> opt2 = customerDao.findById(customerId);
		if(opt.isPresent()) {
			if(opt2.isPresent()) {
				Packages packages = opt.get();
				List<PaymentDetails> pList = packages.getPaymentDetails();
				PaymentDetails userPaymentDetails = bookingDTO.getPaymentDetails();
				pList.add(userPaymentDetails);
				TicketDetails ticketDetails = packages.getTicketDetail();
				ticketDetails.setStatus("booked");

				Booking newBooking = new Booking();
				newBooking.setBookingTitle(packages.getPackageName());
				newBooking.setBookingType("online");
				newBooking.setDescription(packages.getPackageDescription());
				newBooking.setPackages(packages);
				newBooking.setBookingDate(LocalDate.now());

				Customer customer = opt2.get();
				customer.getBookings().add(newBooking);
				packageDao.save(packages);
				return bookingDao.save(newBooking);
			}
			else throw new CustomerException("customer not exists with customer id :"+customerId);
		}
		else throw new PackageException("no package found with packageId :" +bookingDTO.getPackageId());
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingException {
		Optional<Booking> bOptional=bookingDao.findById(bookingId);
		if (bOptional==null) {
			throw new BookingException("No Such Booking exists to cancel");
		}
		bookingDao.delete(bOptional.get());
		return bOptional.get();
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingException {
		Optional<Booking> bOptional=bookingDao.findById(bookingId);
		if (bOptional==null) {
			throw new BookingException("No Such Booking exists to view");
		}
		return bOptional.get();
	}

	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		List<Booking> bookings=bookingDao.findAll();
		if (bookings.isEmpty()) {
			throw new BookingException("No Booking is made till now");
		}
		return bookings;
	}

}
