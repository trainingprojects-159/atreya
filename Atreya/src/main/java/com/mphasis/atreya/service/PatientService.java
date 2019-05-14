package com.mphasis.atreya.service;

import java.util.List;

import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.exceptions.ClinicExceptions;


public interface PatientService {
	public void removePatient(String pid) throws ClinicExceptions;
	public void editPatient(Patient patient) throws ClinicExceptions;
	public Patient getById(String pid) throws ClinicExceptions;
	public List<Patient>getPatients() throws ClinicExceptions;
	public List<Patient>getPatientByName(String pname) throws ClinicExceptions;
	public Patient entry(String pid,String pwd) throws ClinicExceptions;
	public void roll(Patient patient) throws ClinicExceptions;

}
