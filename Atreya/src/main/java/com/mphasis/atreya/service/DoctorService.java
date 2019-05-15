package com.mphasis.atreya.service;

import java.util.List;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface DoctorService {

	public Doctor signin(String doctid, String pwd) throws ClinicExceptions;
	public void addDoctor(Doctor doctor) throws ClinicExceptions;
	public void removeDoctor(String doctid) throws ClinicExceptions;
	public void editDoctor(Doctor doctid) throws ClinicExceptions;
	public Doctor getById(String doctid) throws ClinicExceptions;
	public List<Doctor> getDoctors() throws ClinicExceptions;
}
