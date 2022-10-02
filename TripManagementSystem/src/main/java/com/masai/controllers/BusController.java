package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BusException;
import com.masai.models.Bus;
import com.masai.service.BusService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Buses")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@PostMapping("/add")
	public ResponseEntity<Bus>addbus(@RequestBody Bus bus){
		Bus buses=busService.addBus(bus);

		return new ResponseEntity<Bus>(buses,HttpStatus.CREATED);
		
	}
	@PutMapping("/update")
	public ResponseEntity<Bus>upDateBus(@RequestBody Bus bus) throws BusException{
		Bus buses=busService.upDateBus(bus);

		return new ResponseEntity<Bus>(buses,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Bus>deleteBus(@RequestBody Bus bus) throws BusException{
		Bus buses=busService.deleteBus(bus);

		return new ResponseEntity<Bus>(buses,HttpStatus.OK);
		
	}
}
