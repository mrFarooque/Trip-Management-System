package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.ReportException;
import com.masai.models.Report;

@Service
public interface IReportService {
	public Report addReport(Report report)throws ReportException;
	public Report deleteReport(Integer id)throws ReportException;
	public Report viewReport(Integer id)throws ReportException;
	public List<Report> viewAllReports()throws ReportException;
}
