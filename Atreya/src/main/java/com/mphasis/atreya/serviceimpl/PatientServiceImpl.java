package com.mphasis.atreya.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mphasis.atreya.dao.PatientDao;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.service.PatientService;

@Component
public class PatientServiceImpl implements PatientService {
	

	@Autowired
	PatientDao patientDao;
	

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientDao.insertPatient(patient);

	}

	public void removePatient(String pid) {
		// TODO Auto-generated method stub
		patientDao.deletePatient(pid);
	}

	public void editPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientDao.updatePatient(patient);

	}

	public Patient getById(String pid) {
		// TODO Auto-generated method stub
		return patientDao.getById(pid);
	}

	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patientDao.getPatients();
	}

	public List<Patient> getPatientByName(String pname) {
		// TODO Auto-generated method stub
		return patientDao.getPatientByName(pname);
	}

	public Patient entry(String pname, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("Patient values in service");
		return patientDao.login(pname, pwd);
		
	}
	public void roll(Patient patient) {
		System.out.println("Patient regestraion is successful");
		patientDao.register(patient);
		
	}

}
