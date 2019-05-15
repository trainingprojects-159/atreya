package com.mphasis.atreya.service;

import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface LeaveReportService {
	public void applyLeave(LeaveReport leaveReport) throws ClinicExceptions;
	public void manageLeave(LeaveReport leaveReport) throws ClinicExceptions;
	public List<LeaveReport> getAllReports() throws ClinicExceptions;
}
