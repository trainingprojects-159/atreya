package com.mphasis.atreya.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LeaveReport {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int lrid;
	private String status;
	
	private String leave_details;

	public String getLeave_details() {
		return leave_details;
	}
	public void setLeave_details(String leave_details) {
		this.leave_details = leave_details;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Doctor doctor;
	@ManyToOne(cascade = CascadeType.ALL)
	private Reporter reporter;
	
	public int getLrid() {
		return lrid;
	}
	public void setLrid(int lrid) {
		this.lrid = lrid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Reporter getReporter() {
		return reporter;
	}
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public String toString() {
		return "LeaveReport [lrid=" + lrid + ", status=" + status + ", doctor=" + doctor + ", reporter=" + reporter
				+ "]";
	}
}
