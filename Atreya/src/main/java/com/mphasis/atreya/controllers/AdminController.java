package com.mphasis.atreya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.service.DoctorService;
import com.mphasis.atreya.service.PatientService;
import com.mphasis.atreya.service.ReporterService;



@RestController
public class AdminController {
	@Autowired
	DoctorService doctorService;
    
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	 
	 @RequestMapping(value="/doctor/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public void addDoctor(@RequestBody Doctor d)
	 {
   	    this.doctorService.addDoctor(d); 
	 }
	
	 @RequestMapping(value="/doctor/{doctid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
		public void delerteDoctor(@PathVariable("doctid") String doctid)
		{
	     	this.doctorService.removeDoctor(doctid);
		}
	 @RequestMapping(value="/doctor/{doctid}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
		public void editDoctor(@PathVariable("doctid") String doctid,@RequestBody Doctor d)
		{
		  this.doctorService.editDoctor(d);
		
		}	 
    @Autowired
    PatientService patientService;
    public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

    @RequestMapping(value="/patient/{pid}",method=RequestMethod.PUT)
	public void editPatient(@PathVariable("pid") String pid,@RequestBody Patient p)
	{
	  this.patientService.editPatient(p);
	
	}
    
    @Autowired
	ReporterService reporterService;
    public void setReporterService(ReporterService reporterService) {
		this.reporterService = reporterService;
	}
    
    @RequestMapping(value="/reporter/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public void addReporter(@RequestBody Reporter r)
	 {
  	    this.reporterService.addReporter(r); 
	 }
	  	
}
