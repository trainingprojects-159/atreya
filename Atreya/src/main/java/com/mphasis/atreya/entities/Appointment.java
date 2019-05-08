package com.mphasis.atreya.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	private String appid;
	private String appdetails;
	@Override
	public String toString() {
		return "Appointment [appid=" + appid + ", appdetails=" + appdetails + ", doctor=" + doctor + "]";
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppdetails() {
		return appdetails;
	}
	public void setAppdetails(String appdetails) {
		this.appdetails = appdetails;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@ManyToOne
	@JoinColumn(name="doctid")
	private Doctor doctor;
}
