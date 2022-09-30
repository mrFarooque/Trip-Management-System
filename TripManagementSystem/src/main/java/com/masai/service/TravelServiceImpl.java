package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.TravelsException;
import com.masai.models.Travels;
import com.masai.repository.TravelsDao;

@Service
public class TravelServiceImpl implements TravelsService{
	
	@Autowired
	TravelsDao travelsDao;

	@Override
	public Travels addTavels(Travels travels) {
		return travelsDao.save(travels);
	}

	@Override
	public Travels updateTavels(Travels travels) throws TravelsException{
 		 Optional<Travels> opt = travelsDao.findById(travels.getTravelsId());
 		 if(opt.isPresent()) {
  			 return travelsDao.save(travels);
 		 }
 		 else throw new TravelsException("travels not found with travelID:"+travels.getTravelsId());
	}

	@Override
	public Travels removeTavels(Travels travels) throws TravelsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travels searchTavels(Travels travels) throws TravelsException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travels viewTavels(Travels travels) {
		// TODO Auto-generated method stub
		return null;
	}

}
