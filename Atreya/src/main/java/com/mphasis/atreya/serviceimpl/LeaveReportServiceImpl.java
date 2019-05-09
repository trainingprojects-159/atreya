package com.mphasis.atreya.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.atreya.dao.LeaveReportDao;
import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.service.LeaveReportService;


public class LeaveReportServiceImpl implements LeaveReportService {
	@Autowired
	LeaveReportDao leaveReportDao;

	public void applyLeave(LeaveReport leaveReport) {
		 leaveReportDao.applyLeave(leaveReport);
			
		
	}

	public void manageLeave(LeaveReport leaveReport) {
		leaveReportDao.manageLeave(leaveReport);
	
		
	}

}
