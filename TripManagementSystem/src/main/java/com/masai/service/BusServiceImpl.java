package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BusException;
import com.masai.models.Bus;
import com.masai.repository.BusDao;


@Service
public class BusServiceImpl implements BusService{
	
	@Autowired 
	private BusDao busDao;
	
	@Override
	public Bus addBus(Bus bus) {
		return busDao.save(bus);
	}

	@Override
	public Bus upDateBus(Bus bus)throws BusException {
		Optional<Bus>opt= busDao.findById(bus.getBusNumber());
		if(opt.isPresent()) {
			Bus updateBuses=opt.get();
			return busDao.save(bus);
			
			
		}
		else {
			throw new BusException("Bus Not Found");
		}
		
	
	
	}
	
	

	@Override
	public Bus deleteBus(Bus bus) throws BusException {
		// TODO Auto-generated method stub
		Optional<Bus>opt= busDao.findById(bus.getBusNumber());
		if(opt.isPresent()) {
			Bus deleteBuses=opt.get();
			busDao.delete(deleteBuses);
			
			return deleteBuses;
		}
		else {
			throw new BusException("Bus Not Found");
		}
		
		
	}





	
	
}
