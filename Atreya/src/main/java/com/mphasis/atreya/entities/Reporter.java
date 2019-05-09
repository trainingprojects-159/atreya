package com.mphasis.atreya.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reporter {

	@Id
	private String repid;
	private String pwd;
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Reporter [repid=" + repid + ", leaveReport=" + leaveReport + "]";
	}
	public String getRepid() {
		return repid;
	}
	public void setRepid(String repid) {
		this.repid = repid;
	}
	public List<LeaveReport> getLeaveReport() {
		return leaveReport;
	}
	public void setLeaveReport(List<LeaveReport> leaveReport) {
		this.leaveReport = leaveReport;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private List<LeaveReport> leaveReport;
}
