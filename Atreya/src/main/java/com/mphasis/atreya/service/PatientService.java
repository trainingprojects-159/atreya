package com.mphasis.atreya.service;

import java.util.List;

import com.mphasis.atreya.entities.Patient;


public interface PatientService {
	public void addPatient(Patient patient);
	public void removePatient(String pid);
	public void editPatient(Patient patient);
	public Patient getById(String pid);
	public List<Patient>getPatients();
	public List<Patient>getPatientByName(String pname);
	public Patient entry(String pname,String pwd);
	public void roll(Patient patient);

}
