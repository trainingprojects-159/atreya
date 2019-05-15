package com.mphasis.atreya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.entities.Feedback;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.AppointmentService;
import com.mphasis.atreya.service.FeedbackService;
import com.mphasis.atreya.service.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	FeedbackService feedbackService;

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@RequestMapping(value="/patientlogin/{pid}/{pwd}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Patient login(@PathVariable("pid")String pid,@PathVariable("pwd")String pwd) throws ClinicExceptions {
		Patient user=patientService.entry(pid,pwd);
		return user;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void showRegister(@RequestBody Patient patient) throws ClinicExceptions {
	    patientService.roll(patient);
	}
	 
	@RequestMapping(value = "/patient/{patientid}",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void editPatient(@RequestBody Patient p) throws ClinicExceptions {
        this.patientService.editPatient(p);		
	}
	
	@RequestMapping(value = "/appointment/add", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void requestAppointment(@RequestBody Appointment appointment) throws ClinicExceptions {
	    appointmentService.addAppointment(appointment);
	}
	
	@RequestMapping(value = "/feedback/add", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void createFeedback(@RequestBody Feedback feedback) throws ClinicExceptions {
	    feedbackService.addFeedback(feedback);
	  }
}