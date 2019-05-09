package com.mphasis.atreya.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminid_seq")
    @GenericGenerator(
        name = "adminid_seq", 
        strategy = "com.mphasis.atreya.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AD"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String adminid;
	private String pwd;
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", pwd=" + pwd + "]";
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
