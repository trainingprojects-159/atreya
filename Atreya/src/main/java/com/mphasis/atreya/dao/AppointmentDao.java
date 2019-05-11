package com.mphasis.atreya.dao;

import java.util.List;

import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface AppointmentDao {
	
	public void requestAppointment(Appointment a) throws ClinicExceptions;
	public void deleteAppointment(String id) throws ClinicExceptions;
	public void updateAppointment(Appointment appointment) throws ClinicExceptions;
	public Appointment getById(String id) throws ClinicExceptions;
	public List<Appointment> getAll() throws ClinicExceptions;
	public List<Appointment> getAppointmentByDoctid(String doctid) throws ClinicExceptions;
}
