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
		
		Reporter reporter = null;
		if(repid != null && repid.matches("[RP][0-9]{3}"))
		{
			if(pwd != null && pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				reporter=reporterDao.login(repid, pwd);
			}
			else 
			{
				throw new ClinicExceptions("Entered pwd is invalid");
			}
		}
		else 
		{
			throw new ClinicExceptions("Entered  repid" + repid + " is invalid");
		}
		return reporter;
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

