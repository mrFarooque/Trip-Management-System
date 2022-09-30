package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Packages;
import com.masai.repository.PackageDao;

@Service
public class PackageServiceImpl implements IPackageService{
	
	@Autowired PackageDao packageDao;

	@Override
	public Packages addPackage(Packages packages) {
		return packageDao.save(packages);
	}

}
