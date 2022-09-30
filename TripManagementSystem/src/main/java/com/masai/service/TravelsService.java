package com.masai.service;

import com.masai.exceptions.TravelsException;
import com.masai.models.Travels;

public interface TravelsService {
	public Travels addTavels(Travels travels);
	public Travels updateTavels(Travels travels) throws TravelsException;
	public Travels removeTavels(Travels travels) throws TravelsException;
	public Travels searchTavels(Travels travels) throws TravelsException;
	public Travels viewTavels(Travels travels);
}
