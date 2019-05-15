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
import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.AdminService;
import com.mphasis.atreya.service.AppointmentService;
import com.mphasis.atreya.service.DoctorService;
import com.mphasis.atreya.service.PatientService;
import com.mphasis.atreya.service.ReporterService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}


	@RequestMapping(value="/login/{adminid}/{pwd}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin login(@PathVariable("adminid") String adminid,@PathVariable("pwd") String pwd) throws ClinicExceptions {
		Admin admin=adminService.register(adminid, pwd);
		return admin;
	}
	@Autowired
	DoctorService doctorService;
    
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	 
	 @RequestMapping(value="/doctors",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Doctor> listDoctors() throws ClinicExceptions{
	     return doctorService.getDoctors();
	 }
	 
	 @RequestMapping(value="/doctor/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public void addDoctor(@RequestBody Doctor d) throws ClinicExceptions {
   	    this.doctorService.addDoctor(d); 
	 }
	
	 @RequestMapping(value="/doctor/{doctid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	 public void deleteDoctor(@PathVariable("doctid") String doctid) throws ClinicExceptions{
	     this.doctorService.removeDoctor(doctid);
	 }
	 
	 @RequestMapping(value="/doctor/{doctid}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	 public void editDoctor(@PathVariable("doctid") String doctid,@RequestBody Doctor d) throws ClinicExceptions{
		  this.doctorService.editDoctor(d);
	 }	
	 
	 @RequestMapping(value="/doctor/{doctid}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public Doctor getByDoctorId(@PathVariable("doctid") String doctid) throws ClinicExceptions{
		  return  this.doctorService.getById(doctid);
	 }
	 
    @Autowired
    PatientService patientService;
    public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
    
    @RequestMapping(value="/patient/{pid}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Patient getByPatientId(@PathVariable("pid") String pid) throws ClinicExceptions{
	   return  this.patientService.getById(pid);
	}
    
    @RequestMapping(value="/patient/{pid}",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void editPatient(@PathVariable("pid") String pid,@RequestBody Patient p) throws ClinicExceptions{
	  this.patientService.editPatient(p);
	}
    
    @Autowired
	ReporterService reporterService;
    public void setReporterService(ReporterService reporterService) {
		this.reporterService = reporterService;
	}
    
    @RequestMapping(value="/reporter/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addReporter(@RequestBody Reporter r) throws ClinicExceptions{
  	    this.reporterService.addReporter(r); 
	 }
	  	
    @Autowired
    AppointmentService appointmentService;
    
    @RequestMapping(value="/appointment/{appid}",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateAppointment(@PathVariable("appid") String appid,@RequestBody Appointment a) throws ClinicExceptions{
	  this.appointmentService.editAppointment(a);
	}
}
