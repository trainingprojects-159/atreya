package com.mphasis.atreya.dao;

import java.util.List;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.exceptions.ClinicExceptions;


public interface PatientDao {
	public void deletePatient(String pid) throws ClinicExceptions;
	public void updatePatient(Patient patient) throws ClinicExceptions;
	public Patient getById(String pid) throws ClinicExceptions;
	public List<Patient>getPatients() throws ClinicExceptions;
	public List<Patient>getPatientByName(String pname) throws ClinicExceptions;
	public Patient login(String pid,String pwd) throws ClinicExceptions;
	public void register(Patient patient) throws ClinicExceptions;
	public List<Patient> getPatientByDocId(String doctid) throws ClinicExceptions;

}