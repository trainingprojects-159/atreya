package com.mphasis.atreya.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.*;

import com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctid_seq")
    @GenericGenerator(
        name = "doctid_seq", 
        strategy = "com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DR"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
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
	public List<LeaveReport> getLeaveReport() {
		return leaveReport;
	}
	public void setLeaveReport(List<LeaveReport> leaveReport) {
		this.leaveReport = leaveReport;
	}
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private List<Patient> patient;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Appointment> appointment;
	@OneToMany(cascade=CascadeType.ALL)
	private List<LeaveReport> leaveReport;
	@ManyToMany
	private List<Feedback> feedback;
}
