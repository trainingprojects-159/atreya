package com.mphasis.atreya.service;

import java.util.List;

import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface AppointmentService {

	public void addAppointment(Appointment appointment) throws ClinicExceptions;
	public void removeAppointment(String id);
	public void editAppointment(Appointment appointment);
	public Appointment getById(String id);
	public List<Appointment> getAll();
	public List<Appointment> getAppointmentByDoctid(String doctid);
}
