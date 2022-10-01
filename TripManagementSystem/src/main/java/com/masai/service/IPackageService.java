package com.masai.service;

import com.masai.exceptions.HotelException;
import com.masai.exceptions.PackageException;
import com.masai.exceptions.TicketDetailsException;
import com.masai.models.Hotel;
import com.masai.models.PackageDTO;
import com.masai.models.Packages;

public interface IPackageService {
	Packages addPackage(PackageDTO packages)  ;
	Packages addHotelToPackage(Integer packageID,Integer hotelId) throws PackageException,HotelException;
	public Packages updatePackages(Integer ticketId,Integer packageId) throws TicketDetailsException,PackageException;
}
