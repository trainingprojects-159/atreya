package com.mphasis.atreya.service;

 import com.mphasis.atreya.entities.Reporter;

public interface ReporterService {
	public Reporter login(String repid,String pwd);
	public void addReporter(Reporter reporter);
    public void removeReporter(String repid);
    public void updateReporter(Reporter reporter);
}
