package com.mphasis.atreya.testcasesfordaoimpl;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mphasis.atreya.configurations.AppConfig;
import com.mphasis.atreya.dao.PatientDao;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.exceptions.ClinicExceptions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration

public class TestPatientDaoImpl {
    
	@Autowired
	PatientDao patientDao;
	
	@Test
	public void testLoginPatient(){
		try {
		Patient patient=patientDao.login("PT222", "123");
		assertEquals(patient.getPid(),"PT222");
		
		Patient patient1=patientDao.login("PT11", "123");
		assertEquals(patient1.getPid(),"PT11");
		assertEquals(patient1.getPwd(),"123");
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	
	@Test
	public void registerPatient() throws ClinicExceptions{
	   Patient patient = new Patient(); 
		        patient.setPid("PT234");
		        patient.setPwd("1234");
		        patient.setPname("Arya");
		        patient.setPhnum(1234567890);
		        patient.setAge("45");
		        
		      patientDao.register(patient);
		      assertEquals(patient.getPname(),"Arya");
		        
	    }
	/*@Test
	public void deletePatient() throws ClinicExceptions {
		
		//assertEquals(patientDao.getById("PT001"));
		patientDao.deletePatient("PT001");
	}*/
	

     /*@Test
	public void updatePatient() throws ClinicExceptions {
		
		Patient patient=new Patient();
		patientDao.updatePatient(patient);
		
		assertEquals(patient.getPid(),"PT222");
	}*/
}