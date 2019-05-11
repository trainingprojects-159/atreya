package com.mphasis.atreya.dao;

import java.util.List;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface DoctorDao {

	public Doctor login(String name, String password) throws ClinicExceptions;
	public void insertDoctor(Doctor doctor) throws ClinicExceptions;
	public void deleteDoctor(String doctid) throws ClinicExceptions;
	public void updateDoctor(Doctor doctor) throws ClinicExceptions;
	public Doctor getById(String doctid) throws ClinicExceptions;
	public List<Doctor> getAll() throws ClinicExceptions;
}