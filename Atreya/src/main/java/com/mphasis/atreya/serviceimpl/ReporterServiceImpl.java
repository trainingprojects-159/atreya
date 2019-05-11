package com.mphasis.atreya.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.ReporterDao;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.ReporterService;
@Service
public class ReporterServiceImpl implements ReporterService {
	
	@Autowired
	ReporterDao reporterDao;

	public void setReporterDao(ReporterDao reporterDao) {
		this.reporterDao = reporterDao;
	}

	public Reporter login(String repid, String pwd) throws ClinicExceptions{
		
		return reporterDao.login(repid,pwd);
		
	}

	public void addReporter(Reporter reporter) throws ClinicExceptions{
		 reporterDao.insertReporter(reporter);
		
	}

	public void removeReporter(String repid) throws ClinicExceptions{
		
		reporterDao.deleteReporter(repid);
	}

	public void updateReporter(Reporter reporter) throws ClinicExceptions{
		
		reporterDao.updateReporter(reporter);
	}
	
}
