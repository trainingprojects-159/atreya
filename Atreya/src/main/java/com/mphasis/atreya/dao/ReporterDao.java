package com.mphasis.atreya.dao;

public interface ReporterDao {
public Reporter login(String repid,String pwd);
	public void insertReporter(Reporter reporter);
    public void deleteReporter(String repid);
    public void updateReporter(Reporter reporter);
}
