package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.RouteException;
import com.masai.exceptions.TravelsException;
import com.masai.models.Bus;
import com.masai.models.Hotel;
import com.masai.models.Packages;
import com.masai.models.Route;
import com.masai.models.Travels;
import com.masai.service.BusService;
import com.masai.service.HotelService;
import com.masai.service.IPackageService;
import com.masai.service.IRouteService;
import com.masai.service.ITravelsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired IPackageService packageService;
	@Autowired HotelService hotelService;
	@Autowired IRouteService routeService;
	@Autowired BusService busService;
	@Autowired ITravelsService travelsService;
	
	@PostMapping("/packages")
	public ResponseEntity<Packages> addPackages(@RequestBody Packages packages){
		Packages packages2 = packageService.addPackage(packages);
		return new ResponseEntity<Packages>(packages2,HttpStatus.OK);
	}
	
	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		Hotel hotel2 = hotelService.addHotel(hotel);
		return new ResponseEntity<Hotel>(hotel2,HttpStatus.OK);
	}
	
	@PostMapping("/routes")
	public ResponseEntity<Route> addRoute(@RequestBody Route route){
		Route route2 = routeService.addRoute(route);
		return new ResponseEntity<Route>(route2,HttpStatus.OK);
	}
	
	@PutMapping("/routes")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) throws RouteException{
		Route route2 = routeService.updateRoute(route);
		return new ResponseEntity<Route>(route2,HttpStatus.OK);
	}
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addHotel(@RequestBody Bus bus){
		Bus bus2 = busService.addBus(bus); 
		return new ResponseEntity<Bus>(bus2,HttpStatus.OK);
	}
	
	@PostMapping("/travels")
	public ResponseEntity<Travels> addHotel(@RequestBody Travels travels){
		Travels travels2 = travelsService.addTravels(travels); 
		return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
	
	@PutMapping("/travels")
	public ResponseEntity<Travels> updateHotel(@RequestBody Travels travels) throws TravelsException{
		Travels travels2 = travelsService.updateTravels(travels);
		return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
}
