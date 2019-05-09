package com.mphasis.atreya.dao;

import java.util.List;

import com.mphasis.atreya.entities.Patient;


public interface PatientDao {
	public void insertPatient(Patient patient);
	public void deletePatient(String pid);
	public void updatePatient(Patient patient);
	public Patient getById(String pid);
	public List<Patient>getPatients();
	public List<Patient>getPatientByName(String pname);
	public Patient login(String pname,String pwd);
	public void register(Patient patient);

}
