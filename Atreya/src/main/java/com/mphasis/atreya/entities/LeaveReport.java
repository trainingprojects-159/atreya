package com.mphasis.atreya.entities;

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
	@Override
	public String toString() {
		return "LeaveReport [lrid=" + lrid + ", status=" + status + ", doctor=" + doctor + ", reporter=" + reporter
				+ "]";
	}
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
	@ManyToOne
	@JoinColumn(name="doctid")
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(name="repid")
	private Reporter reporter;
}
