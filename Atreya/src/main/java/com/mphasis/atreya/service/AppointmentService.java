package com.mphasis.atreya.service;

import java.util.List;

import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface AppointmentService {

	public void addAppointment(Appointment appointment) throws ClinicExceptions;
	public void removeAppointment(String id) throws ClinicExceptions;
	public void editAppointment(Appointment appointment) throws ClinicExceptions;
	public Appointment getById(String id) throws ClinicExceptions;
	public List<Appointment> getAll() throws ClinicExceptions;
	public List<Appointment> getAppointmentByDoctid(String doctid) throws ClinicExceptions;
}
