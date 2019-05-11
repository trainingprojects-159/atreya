package com.mphasis.atreya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.service.AppointmentService;
import com.mphasis.atreya.service.DoctorService;
import com.mphasis.atreya.service.LeaveReportService;
import com.mphasis.atreya.service.PatientService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	LeaveReportService leaveReportService;
	@Autowired
	PatientService patientService;
	
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	public void setLeaveReportService(LeaveReportService leaveReportService) {
		this.leaveReportService = leaveReportService;
	}
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping(value="/doctorlogin", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Doctor login(@RequestParam("doctid")String doctid,@RequestParam("pwd")String pwd) {
		Doctor doctor=doctorService.signin(doctid, pwd);
		return doctor;
	}
	
	@RequestMapping(value="/appointment/{doctid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppByDoctid(@PathVariable("doctid")String doctid) {
		return this.appointmentService.getAppointmentByDoctid(doctid);
	}
	
	@RequestMapping(value="/leavereport/add", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void applyLeave(@RequestBody LeaveReport lr) {
		this.leaveReportService.applyLeave(lr);
	}
	
	@RequestMapping(value="/patient/{pid}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void editPatient(@PathVariable("pid")int pid, @RequestBody Patient p) {
		this.patientService.editPatient(p);
	}
}
