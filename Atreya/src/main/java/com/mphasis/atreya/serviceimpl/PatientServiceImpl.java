package com.mphasis.atreya.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.PatientDao;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	

	@Autowired
	PatientDao patientDao;
	

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	public void removePatient(String pid) throws ClinicExceptions{
		
		patientDao.deletePatient(pid);
	}

	public void editPatient(Patient patient) throws ClinicExceptions{
		patientDao.updatePatient(patient);
	}

	public Patient getById(String pid) throws ClinicExceptions{
		return patientDao.getById(pid);
	}

	public List<Patient> getPatients() throws ClinicExceptions{
	
		return patientDao.getPatients();
	}

	public List<Patient> getPatientByName(String pname) throws ClinicExceptions{
		return patientDao.getPatientByName(pname);
	}

	public Patient entry(String pid, String pwd) throws ClinicExceptions{
		Patient patient = null;
		if(pid != null && pid.matches("[PT][0-9]{3}"))
		{
			if(pwd != null && pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				patient=patientDao.login(pid, pwd);
			}
			else 
			{
				throw new ClinicExceptions("Entered pwd " + pwd + " is invalid");
			}
		}
		else 
		{
			throw new ClinicExceptions("Entered patientid " + pid + " is invalid");
		}
		return patient;
	}
	
	public void roll(Patient patient) throws ClinicExceptions{
		System.out.println("Patient regestraion is successful");
		patientDao.register(patient);
	}

	public List<Patient> getPatientByDoctid(String doctid) throws ClinicExceptions {
		return patientDao.getPatientByDocId(doctid);
	}
}