package com.mphasis.atreya.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.DoctorDao;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	
	@Autowired
	DoctorDao doctorDao;
	
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	public void addDoctor(Doctor doctor) throws ClinicExceptions{
		doctorDao.insertDoctor(doctor);
		
	}

	public void removeDoctor(String doctid) throws ClinicExceptions{
		doctorDao.deleteDoctor(doctid);
		
	}

	public void editDoctor(Doctor doctid) throws ClinicExceptions{
		doctorDao.updateDoctor(doctid);
		
	}

	public Doctor getById(String doctid) throws ClinicExceptions{
		
		return doctorDao.getById(doctid);
	}

	public List<Doctor> getDoctors() throws ClinicExceptions{
		
		return doctorDao.getAll();
	}

	public Doctor signin(String doctname, String pwd) throws ClinicExceptions{
		Doctor doctor = null;
		if(doctname != null && doctname.matches("[A-Za-z]{10}"))
		{
			if(pwd != null && pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				doctor=doctorDao.login(doctname, pwd);
			}
			else 
			{
				throw new ClinicExceptions("Entered password is invalid");
			}
		}
		else 
		{
			throw new ClinicExceptions("Entered doctorname " + doctname + " is invalid");
		}
		return doctor;
	}
}

