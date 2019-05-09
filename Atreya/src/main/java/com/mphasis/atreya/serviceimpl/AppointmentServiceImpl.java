package com.mphasis.atreya.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.AppointmentDao;
import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
@Autowired
AppointmentDao appointmentDao;
public void setAppointmentDao(AppointmentDao appointmentDao) {
	this.appointmentDao=appointmentDao;
}
	

	public void addAppointment(Appointment appointment) {
		System.out.println("Appointment granted"+appointment.getAppid());
		appointmentDao.requestAppointment(appointment);
		
	}

	public void removeAppointment(String id) {
		appointmentDao.deleteAppointment(id);
		
	}

	public void editAppointment(Appointment appointment) {
		appointmentDao.updateAppointment(appointment);
		
	}

	public Appointment getById(String id) {
	return appointmentDao.getById(id);
		
	}

	public List<Appointment> getAll() {
		return appointmentDao.getAll();
		
	}

	public List<Appointment> getAppointmentByDoctid(String doctid) {
		return appointmentDao.getAppointmentByDoctid(doctid);
	}

}
