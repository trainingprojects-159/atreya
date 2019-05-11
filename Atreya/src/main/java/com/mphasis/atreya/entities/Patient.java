package com.mphasis.atreya.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @GenericGenerator(
        name = "patient_seq", 
        strategy = "com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PT"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String pid;
	private String pwd;
	private String pname;
	private long phnum;
	private String age;
	private String gender;
	private String report;
	@ManyToOne
	private Doctor doctor;
	
	@OneToOne
	private Appointment appointment;
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
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
	
}
