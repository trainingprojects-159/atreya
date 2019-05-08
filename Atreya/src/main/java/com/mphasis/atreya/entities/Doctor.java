package com.mphasis.atreya.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	private String doctid;
	private String pwd;
	private String doctname;
	private String specialization;
	@Override
	public String toString() {
		return "Doctor [doctid=" + doctid + ", pwd=" + pwd + ", doctname=" + doctname + ", specialization="
				+ specialization + ", patient=" + patient + ", appointment=" + appointment + ", leaveReport="
				+ leaveReport + ", feedback=" + feedback + "]";
	}
	public String getDoctid() {
		return doctid;
	}
	public void setDoctid(String doctid) {
		this.doctid = doctid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDoctname() {
		return doctname;
	}
	public void setDoctname(String doctname) {
		this.doctname = doctname;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	public LeaveReport getLeaveReport() {
		return leaveReport;
	}
	public void setLeaveReport(LeaveReport leaveReport) {
		this.leaveReport = leaveReport;
	}
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	@OneToMany(mappedBy="patient", cascade=CascadeType.ALL)
	private List<Patient> patient;
	@OneToMany(mappedBy="appointment", cascade=CascadeType.ALL)
	private List<Appointment> appointment;
	@OneToMany(mappedBy="leaveReport", cascade=CascadeType.ALL)
	private LeaveReport leaveReport;
	@ManyToMany
	private List<Feedback> feedback;
}
