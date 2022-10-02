package com.masai.service;

import java.util.List;

import com.masai.exceptions.HotelException;
import com.masai.exceptions.PackageException;
import com.masai.exceptions.TicketDetailsException;
import com.masai.models.FullPackageDTO;
import com.masai.models.Hotel;
import com.masai.models.PackageDTO;
import com.masai.models.Packages;

public interface IPackageService {
	Packages addPackage(PackageDTO packages);
	Packages addPackage(FullPackageDTO packages);
	Packages addHotelToPackage(Integer packageID,Integer hotelId) throws PackageException,HotelException;
	Packages updatePackages(Integer ticketId,Integer packageId) throws TicketDetailsException,PackageException;
	public Packages deletePackage(int packageId)throws PackageException;
	public List<Packages> viewAllPackage()throws PackageException;
	public Packages searchPackage(int packageId)throws PackageException;
}
