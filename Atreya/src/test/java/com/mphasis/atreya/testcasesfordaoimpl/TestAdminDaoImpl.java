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
import com.mphasis.atreya.dao.AdminDao;
import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.exceptions.ClinicExceptions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@Transactional
public class TestAdminDaoImpl {
	
	@Autowired
	AdminDao adminDao;

	@Test
	public void testAdminLogin() {
		try {
	Admin admin=adminDao.login("AD222", "234");
	assertEquals(admin.getAdminid(),"AD222");
	assertEquals(admin.getPwd(), "234");
	
	Admin admin1=adminDao.login("AD11", "123");
	assertNull(admin1);
	}catch(Exception e) {
		e.printStackTrace();
		}
	}
}
