package com.mphasis.atreya.dao;

import java.util.List;

import com.mphasis.atreya.entities.Appointment;

public interface AppointmentDao {
	public void requestAppointment(Appointment a);
	public void deleteAppointment(String id);
	public void updateAppointment(Appointment appointment);
	public Appointment getById(String id);
	public List<Appointment> getAll();
	public List<Appointment> getAppointmentByDoctid(String doctid);
}
