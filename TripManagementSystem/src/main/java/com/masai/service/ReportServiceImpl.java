package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ReportException;
import com.masai.models.Admin;
import com.masai.models.Report;
import com.masai.repository.AdminDao;
import com.masai.repository.ReportDao;

@Service
public class ReportServiceImpl implements IReportService{

	@Autowired
	private ReportDao reportDao;
	@Autowired AdminDao adminDao;
	
	@Override
	public Report addReport(Report report,Integer adminId) throws AdminException {
		Optional<Admin> previousAdmin = adminDao.findById(adminId);  
		if(!previousAdmin.isPresent()) {
			throw new AdminException("No admin with adminId:"+adminId);
		}else {
			Admin admin = previousAdmin.get();
			admin.getReports().add(report);
			return reportDao.save(report);
		}
	}

	@Override
	public Report deleteReport(Integer id) throws ReportException {
		Optional<Report> previousReport =  reportDao.findById(id);
		if(previousReport.isPresent()) {
			reportDao.deleteById(id);
			return previousReport.get();			
		}else {		
			throw new ReportException("Report Not found with id : "+id);
		}
	}

	@Override
	public Report viewReport(Integer id) throws ReportException {
		Optional<Report> previousReport =  reportDao.findById(id);
		if(previousReport.isPresent()) {
			return previousReport.get();			
		}else {		
			throw new ReportException("Report Not found with id : "+id);
		}
	}

	@Override
	public List<Report> viewAllReports() throws ReportException {
		List<Report> allReports = reportDao.findAll();
		if(allReports.size()>0) {
			return allReports;
		}else {
			throw new ReportException("No Reports found for now!");
		}
	}
	
}
