package com.mphasis.atreya.dao;

import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface LeaveReportDao {

	public void applyLeave(LeaveReport leaveReport) throws ClinicExceptions;
	public void manageLeave(LeaveReport leaveReport) throws ClinicExceptions;
	public List<LeaveReport> getAllReports() throws ClinicExceptions;
}
