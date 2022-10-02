package com.masai.service;

import com.masai.exceptions.BusException;
import com.masai.models.Bus;

public interface BusService {
	public Bus addBus(Bus bus);
	public Bus upDateBus(Bus bus) throws BusException  ;
	public Bus deleteBus(Bus bus) throws BusException;
	
}
