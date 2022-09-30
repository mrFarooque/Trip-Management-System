package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.TravelsException;
import com.masai.models.Travels;
import com.masai.service.TravelsService;

@RestController
public class TravelsController {
	
	@Autowired
	TravelsService travelsService;
	
	@PostMapping("/admin/travels")
	public ResponseEntity<Travels> addTavels(@RequestBody Travels travels){
 		Travels travels2 = travelsService.addTavels(travels);
 		return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
	
	@PutMapping("/admin/travels")
	public ResponseEntity<Travels> updateTavels(@RequestBody Travels travels) throws TravelsException{
  		 Travels updatedtravels = travelsService.updateTavels(travels);
  		 return new ResponseEntity<Travels>(updatedtravels,HttpStatus.OK);
	}
//	public Travels removeTavels(Travels travels) throws TravelsException;
//	public Travels searchTavels(Travels travels) throws TravelsException;
//	public Travels viewTavels(Travels travels);
}
