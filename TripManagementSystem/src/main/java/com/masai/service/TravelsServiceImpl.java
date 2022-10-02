package com.masai.service;

import java.util.List;
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
	public Travels addTravels(Travels travels) throws TravelsException {
		Optional<Travels> rOptional=travelsDao.findById(travels.getTravelsId());
		if (rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is already available in database");
		}
		return travelsDao.save(travels);
	}

	@Override
	public Travels updateTravels(Travels travels) throws TravelsException {
		Optional<Travels> rOptional=travelsDao.findById(travels.getTravelsId());
		if (!rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is not available in database to update");
		}
		return travelsDao.save(travels);
	}

	@Override
	public Travels removeTravels(int travelId) throws TravelsException {
		Optional<Travels> rOptional=travelsDao.findById(travelId);
		if (!rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is not present in database to remove");
		}
		travelsDao.delete(rOptional.get());
		return rOptional.get();
	}

	@Override
	public Travels searchTravels(int travelId) throws TravelsException {
		Optional<Travels> rOptional=travelsDao.findById(travelId);
		if (!rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is not present in database to show");
		}
		return rOptional.get();
	}	

	@Override
	public List<Travels> viewTravels() throws TravelsException {
		List<Travels> lTravels=travelsDao.findAll();
		if (lTravels.isEmpty()) {
			throw new TravelsException("This Travelservice is not present in database to remove");
		}
		return lTravels;
	}
	
	

	
	
	
	
//	@Override
//	public Travels addTravels(Travels travels) {
//		return travelsDao.save(travels);
//	}
//
//	@Override
//	public Travels updateTravels(Travels travels) throws TravelsException {
//		Optional<Travels> opt = travelsDao.findById(travels.getTravelsId());
//		if(opt.isPresent()) {
//			return travelsDao.save(travels);
//		}
//		else throw new TravelsException("travel not found with travel id : " + travels.getTravelsId());
//	}
	
	
	

}
