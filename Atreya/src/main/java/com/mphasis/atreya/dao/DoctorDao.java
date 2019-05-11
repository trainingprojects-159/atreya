package com.mphasis.atreya.dao;

import java.util.List;
import com.mphasis.atreya.entities.Doctor;

public interface DoctorDao {

	public Doctor login(String name, String password);
	public void insertDoctor(Doctor doctor);
	public void deleteDoctor(String doctid);
	public void updateDoctor(Doctor doctor);
	public Doctor getById(String doctid);
	public List<Doctor> getAll();
}