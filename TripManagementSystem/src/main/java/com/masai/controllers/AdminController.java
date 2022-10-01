package com.masai.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.exceptions.HotelException;
import com.masai.exceptions.PackageException;
import com.masai.exceptions.ReportException;
import com.masai.exceptions.TicketDetailsException;
import com.masai.exceptions.TravelsException;
import com.masai.models.Bus;
import com.masai.models.Feedback;
import com.masai.models.Hotel;
import com.masai.models.PackageDTO;
import com.masai.models.Packages;
import com.masai.models.Report;
import com.masai.models.Route;
import com.masai.models.Travels;
import com.masai.service.BusService;
import com.masai.service.HotelService;
import com.masai.service.IFeedbackService;
import com.masai.service.IPackageService;
import com.masai.service.IReportService;
import com.masai.service.IRouteService;
import com.masai.service.ITravelsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IPackageService packageService;
	@Autowired
	HotelService hotelService;
	@Autowired
	IRouteService routeService;
	@Autowired
	BusService busService;
	@Autowired
	ITravelsService travelsService;
	@Autowired
	IFeedbackService feedbackService;
	@Autowired
	IReportService reportService;

	@PostMapping("/packages")
	public ResponseEntity<Packages> addPackages(@RequestBody PackageDTO packages) {
		Packages packages2 = packageService.addPackage(packages);
		return new ResponseEntity<Packages>(packages2, HttpStatus.OK);
	}

	@PutMapping("/addHotelToPackage/{packageid}/{hotelid}")
	public ResponseEntity<Packages> addHotelToPackage(@PathVariable("packageid") Integer packageId,
			@PathVariable("hotelid") Integer hotelId) throws PackageException, HotelException {
		Packages packages2 = packageService.addHotelToPackage(packageId, hotelId);
		return new ResponseEntity<Packages>(packages2, HttpStatus.OK);
	}

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		Hotel hotel2 = hotelService.addHotel(hotel);
		return new ResponseEntity<Hotel>(hotel2, HttpStatus.OK);
	}

	@PostMapping("/routes")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) {
		Route route2 = routeService.addRoute(route);
		return new ResponseEntity<Route>(route2, HttpStatus.OK);
	}

	@PutMapping("/addTicketDetailsToPackages/{ticketId}/{packageId}")
	public ResponseEntity<Packages> updateRoute(@PathVariable("ticketId") Integer ticketId,
			@PathVariable("packageId") Integer packageId) throws TicketDetailsException, PackageException {
		Packages packages = packageService.updatePackages(ticketId, packageId);
		return new ResponseEntity<Packages>(packages, HttpStatus.OK);
	}

	@PostMapping("/bus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
		Bus bus2 = busService.addBus(bus);
		return new ResponseEntity<Bus>(bus2, HttpStatus.OK);
	}

	@PostMapping("/travels")
	public ResponseEntity<Travels> addTravles(@RequestBody Travels travels) {
		Travels travels2 = travelsService.addTravels(travels);
		return new ResponseEntity<Travels>(travels2, HttpStatus.OK);
	}

	@PutMapping("/travels")
	public ResponseEntity<Travels> updateTravels(@RequestBody Travels travels) throws TravelsException {
		Travels travels2 = travelsService.updateTravels(travels);
		return new ResponseEntity<Travels>(travels2, HttpStatus.OK);
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable Integer id) throws FeedbackException {
		Feedback feedback = feedbackService.findByFeedbackId(id);
		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
	}

	@GetMapping("/feedbacks/{id}")
	public ResponseEntity<List<Feedback>> getFeedbackByCustomerId(@PathVariable Integer id)
			throws FeedbackException, CustomerException {
		List<Feedback> feedbackList = feedbackService.findByCustomerId(id);
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() throws FeedbackException {
		List<Feedback> feedbackList = feedbackService.viewAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	@DeleteMapping("/report/{id}")
	public ResponseEntity<Report> deleteReport(@PathVariable Integer id) throws ReportException {
		Report report = reportService.deleteReport(id);
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}

	@GetMapping("/report/{id}")
	public ResponseEntity<Report> getReport(@PathVariable Integer id) throws ReportException {
		Report report = reportService.viewReport(id);
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}

	@GetMapping("/reports")
	public ResponseEntity<List<Report>> getAllReports() throws ReportException {
		List<Report> reportList = reportService.viewAllReports();
		return new ResponseEntity<List<Report>>(reportList, HttpStatus.OK);
	}

}
