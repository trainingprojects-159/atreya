package com.mphasis.atreya.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.service.PatientService;


@RestController
public class PatientController {
	@Autowired
	PatientService patientService;

	public void setpatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Patient login(@RequestParam("pname")String pname,@RequestParam("pwd")String pwd) {
		Patient user=patientService.entry(pname,pwd);
		return user;
	}

	@RequestMapping("/home")
	public String getPage() {
		return "index";
	}
	
	  @RequestMapping(value = "/register", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	  public void showRegister(@RequestBody Patient patient) {
	    patientService.addPatient(patient);
	  }
	 
	  @RequestMapping(value="/patient/{patientid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	  public void removepatient(@PathVariable ("patientid") String patientid) {
		  this.patientService.removePatient(patientid);
	  }
	
	  @RequestMapping(value="/patient",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void editpatient(@RequestBody Patient c) {
        this.patientService.editPatient(c);		
	}
	

}
