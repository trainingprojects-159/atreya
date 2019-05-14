package com.mphasis.atreya.testcasesfordaoimpl;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.mphasis.atreya.configurations.AppConfig;
import com.mphasis.atreya.dao.DoctorDao;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.exceptions.ClinicExceptions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@Transactional
public class TestDoctorDaoImpl {

	@Autowired
	DoctorDao doctorDao;
	
	@Test
	public void testLogin() {
		try {
		Doctor doctor=doctorDao.login("DR111", "123");
		
		assertEquals(doctor.getDoctid(), "DR111");
		assertEquals(doctor.getPwd(), "123");
		
		Doctor doctor1=doctorDao.login("DR11", "1423");
		assertEquals(doctor1.getDoctid(), "DR11");
		assertEquals(doctor1.getPwd(), "1423");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testGetById() throws ClinicExceptions {
		Doctor doctor=doctorDao.getById("DR004");
		
		assertEquals(doctor.getDoctid(), "DR004");
	}
	
	
	/*@Test
	public void testInsertDoctor() throws ClinicExceptions {
		Doctor doctor=new Doctor();
		doctor.setPwd("345");
		doctor.setDoctname("Tushar");
		doctor.setSpecialization("MBBS");
		
		doctorDao.insertDoctor(doctor);
		
		assertEquals(doctor.getPwd(), "345");
		assertEquals(doctor.getDoctname(), "Tushar");
		assertEquals(doctor.getSpecialization(), "MBBS");
	}*/
	
	@Test 
	public void testGetAll() throws ClinicExceptions {
		Doctor doctor=new Doctor();
		java.util.List<Doctor> doctors=doctorDao.getAll();
		
		assertEquals(doctors.size(), 4);
	}
	
	/*@Test
	public void testDeleteDoc() throws ClinicExceptions {
		
		
		doctorDao.deleteDoctor("DR001");
		assertNull(doctorDao.getById("DR001"));
	}*/
	
	
	/*@Test
	public void testUpdateDoc() {
		
		Doctor doctor=new Doctor();		
		
		try {
			doctorDao.getById("DR008");
		} catch (ClinicExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doctor.setSpecialization("Cardio");
		
		try {
			doctorDao.updateDoctor(doctor);
		} catch (ClinicExceptions e) {
			e.printStackTrace();
		}
		
		assertEquals(doctor.getDoctid(), "DR008");
	}*/
	/*@Test
	public void Testdeletedoctor() throws ClinicExceptions {
		Doctor doctor=new Doctor();
		doctor=doctorDao.getById("DR111");
		doctorDao.deleteDoctor("DR111");*/
		
  //}
}
