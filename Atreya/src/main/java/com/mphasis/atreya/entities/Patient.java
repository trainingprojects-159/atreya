package com.mphasis.atreya.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {

	@Id
	private String pid;
	private String pwd;
	private String pname;
	private long phnum;
	private String age;
	private String gender;
	private String report;
	
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pwd=" + pwd + ", pname=" + pname + ", phnum=" + phnum + ", age=" + age
				+ ", gender=" + gender + ", report=" + report + ", appointment=" + appointment + "]";
	}
	public long getPhnum() {
		return phnum;
	}
	public void setPhnum(long phnum) {
		this.phnum = phnum;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@OneToOne
	private Appointment appointment;
}
