package com.mphasis.atreya.service;

import java.util.List;
import com.mphasis.atreya.entities.Doctor;

public interface DoctorService {

	public Doctor signin(String doctname, String pwd);
	public void addDoctor(Doctor doctor);
	public void removeDoctor(String doctid);
	public void editDoctor(Doctor doctid);
	public Doctor getById(String doctid);
	public List<Doctor> getDoctors();
}
