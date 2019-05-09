package com.mphasis.atreya.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int slno;
	public int getSlno() {
		return slno;
	}
	@Override
	public String toString() {
		return "Feedback [slno=" + slno + ", feedback=" + feedback + ", doctor=" + doctor + "]";
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	private String feedback;
	@ManyToMany(mappedBy="feedback", cascade=CascadeType.ALL)
	@JoinColumn(name="doctid")
	private List<Doctor> doctor;
	
}
