package com.mphasis.atreya.dao;

import com.mphasis.atreya.entities.Reporter;

public interface ReporterDao {
	public Reporter login(String repid,String pwd);
	public void insertReporter(Reporter reporter);
    public void deleteReporter(String repid);
    public void updateReporter(Reporter reporter);
}
