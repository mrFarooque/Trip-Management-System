package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Hotel;
import com.masai.repository.HotelDao;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired 
	HotelDao hotelDao;

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelDao.save(hotel);
	}

}
