package com.mphasis.atreya.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.*;

import com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @GenericGenerator(
        name = "appointment_seq", 
        strategy = "com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "APP"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })

	private String appid;
	private String appdetails;
	@ManyToOne
	private Doctor doctor;
	
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
}
