package com.mphasis.atreya.testcasesfordaoimpl;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.mphasis.atreya.dao.ReporterDao;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.entities.Reporter;
import com.mphasis.atreya.exceptions.ClinicExceptions;
public class TestReporterDaoImpl {

	
	@Autowired
	ReporterDao reporterDao;

	/*@Test
	public void testReporterLogin() {
		try {
	Reporter reporter=reporterDao.login("RP888", "345");
	assertEquals(reporter.getRepid(),"RP888");
	assertEquals(reporter.getPwd(), "345");
	
	Reporter reporter1=reporterDao.login("RP88", "123");
	assertNull(reporter1);
	}catch(Exception e) {
		e.printStackTrace();
		}
	}*/
	
	@Test
	public void testInsertReporter() throws ClinicExceptions {
		Reporter reporter=new Reporter();
		reporter.setPwd("345");
		
		
	reporterDao.insertReporter(reporter);
		assertEquals(reporter.getPwd(), "345");
		
	}
}
