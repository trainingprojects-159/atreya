package com.mphasis.atreya.service;

 import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface ReporterService {
	public Reporter login(String repid,String pwd) throws ClinicExceptions;
	public void addReporter(Reporter reporter) throws ClinicExceptions;
    public void removeReporter(String repid) throws ClinicExceptions;
    public void updateReporter(Reporter reporter) throws ClinicExceptions;
}
