package com.mphasis.atreya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.service.ReporterService;



@RestController
public class ReporterController {
    @Autowired
	ReporterService reporterService;
    


	public void setReporterService(ReporterService reporterService) {
		this.reporterService = reporterService;
	}
	@Autowired
    LeaveReportService leaveReportService;
	
	
	
	@RequestMapping(value="/reporter/{lrid}",method=RequestMethod.PUT) 
	public void updateReporter(@PathVariable("lrid")int lrid,@RequestBody LeaveReport lr) {
		
		this.leavereporterService.manageLeave(lr);
	}
}
