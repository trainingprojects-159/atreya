package com.mphasis.atreya.dao;

import com.mphasis.atreya.entities.LeaveReport;

public interface LeaveReportDao {

	public void applyLeave(LeaveReport leaveReport);
	public void manageLeave(LeaveReport leaveReport);
}
