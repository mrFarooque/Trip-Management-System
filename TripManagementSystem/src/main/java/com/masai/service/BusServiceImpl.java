package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Bus;
import com.masai.repository.BusDao;

@Service
public class BusServiceImpl implements BusService{
	
	@Autowired BusDao busDao;
	
	@Override
	public Bus addBus(Bus bus) {
		return busDao.save(bus);
	}
	
}
