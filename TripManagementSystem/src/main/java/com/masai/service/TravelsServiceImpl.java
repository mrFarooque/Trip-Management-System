package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.TravelsException;
import com.masai.models.Travels;
import com.masai.repository.TravelsDao;

@Service
public class TravelsServiceImpl implements ITravelsService{
	@Autowired TravelsDao travelsDao;
	
	@Override
	public Travels addTravels(Travels travels) {
		return travelsDao.save(travels);
	}

	@Override
	public Travels updateTravels(Travels travels) throws TravelsException {
		Optional<Travels> opt = travelsDao.findById(travels.getTravelsId());
		if(opt.isPresent()) {
			return travelsDao.save(travels);
		}
		else throw new TravelsException("travel not found with travel id : " + travels.getTravelsId());
	}
	
	
	

}
