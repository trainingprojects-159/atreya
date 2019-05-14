package com.mphasis.atreya.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.AppointmentDao;
import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
@Autowired
AppointmentDao appointmentDao;
public void setAppointmentDao(AppointmentDao appointmentDao) {
	this.appointmentDao=appointmentDao;
}
	

	public void addAppointment(Appointment appointment) throws ClinicExceptions{
		System.out.println("Appointment granted"+appointment.getAppid());
		appointmentDao.requestAppointment(appointment);
		
	}

	public void removeAppointment(String id) throws ClinicExceptions {
		appointmentDao.deleteAppointment(id);
		
	}

	public void editAppointment(Appointment appointment) throws ClinicExceptions {
		appointmentDao.updateAppointment(appointment);
		
	}

	public Appointment getById(String id) throws ClinicExceptions {
	return appointmentDao.getById(id);
		
	}
	

	public List<Appointment> getAll() throws ClinicExceptions {
		return appointmentDao.getAll();
		
	}

	public List<Appointment> getAppointmentByDoctid(String doctid) throws ClinicExceptions {
		return appointmentDao.getAppointmentByDoctid(doctid);
	}
}