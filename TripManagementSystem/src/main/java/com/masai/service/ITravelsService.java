package com.masai.service;

import com.masai.exceptions.TravelsException;
import com.masai.models.Travels;

public interface ITravelsService {
	Travels addTravels(Travels travels);
	Travels updateTravels(Travels travels) throws TravelsException;
}
