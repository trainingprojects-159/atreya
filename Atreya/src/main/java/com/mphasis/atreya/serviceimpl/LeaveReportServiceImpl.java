package com.mphasis.atreya.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.LeaveReportDao;
import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.LeaveReportService;

@Service
public class LeaveReportServiceImpl implements LeaveReportService {
	@Autowired
	LeaveReportDao leaveReportDao;

	public void applyLeave(LeaveReport leaveReport) throws ClinicExceptions{
		 leaveReportDao.applyLeave(leaveReport);
	}

	public void manageLeave(LeaveReport leaveReport) throws ClinicExceptions{
		leaveReportDao.manageLeave(leaveReport);
	}

}
