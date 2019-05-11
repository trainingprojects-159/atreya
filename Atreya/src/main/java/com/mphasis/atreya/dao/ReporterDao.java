package com.mphasis.atreya.dao;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.exceptions.ClinicExceptions;
public interface ReporterDao {
public Reporter login(String repid,String pwd) throws ClinicExceptions;
	public void insertReporter(Reporter reporter) throws ClinicExceptions;
    public void deleteReporter(String repid) throws ClinicExceptions;
    public void updateReporter(Reporter reporter) throws ClinicExceptions;
}
