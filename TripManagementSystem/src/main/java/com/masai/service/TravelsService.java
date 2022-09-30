package com.masai.service;

import com.masai.models.Travels;

public interface TravelsService {
	public Travels addTavels(Travels travels);
	public Travels updateTavels(Travels travels);
	public Travels removeTavels(Travels travels);
	public Travels searchTavels(Travels travels);
	public Travels viewTavels(Travels travels);
}
