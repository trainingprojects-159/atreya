package com.mphasis.atreya.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Reporter {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repid_seq")
    @GenericGenerator(
        name = "repid_seq", 
        strategy = "com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RP"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String repid;
	private String pwd;
	@OneToMany(mappedBy="reporter",cascade=CascadeType.ALL)
	private List<LeaveReport> leaveReport;
	
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
	
}
