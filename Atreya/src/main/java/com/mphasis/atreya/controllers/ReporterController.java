package com.mphasis.atreya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.LeaveReportService;
import com.mphasis.atreya.service.ReporterService;



@RestController
@RequestMapping("/reporter")
public class ReporterController {
    @Autowired
	ReporterService reporterService;
    
        public void setReporterService(ReporterService reporterService) {
		this.reporterService = reporterService;
	}
	
	@Autowired
    LeaveReportService leaveReportService;
	
	public void setLeaveReportService(LeaveReportService leaveReportService) {
		this.leaveReportService = leaveReportService;
	}

	@RequestMapping(value="/reporterlogin/{repid}/{pwd}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Reporter login(@PathVariable("repid")String repid,@PathVariable("pwd")String pwd) throws ClinicExceptions {
		Reporter reporter=reporterService.login(repid,pwd);
		return reporter;
	}
	
	@RequestMapping(value="/leavereport/{lrid}",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE) 
	public void updateleaveReport(@PathVariable("lrid")int lrid,@RequestBody LeaveReport lr) throws ClinicExceptions {
		this.leaveReportService.manageLeave(lr);
	}
}
