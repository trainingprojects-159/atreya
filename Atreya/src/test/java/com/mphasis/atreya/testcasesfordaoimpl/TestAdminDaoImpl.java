package com.mphasis.atreya.testcasesfordaoimpl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.atreya.dao.AdminDao;
import com.mphasis.atreya.entities.Admin;

public class TestAdminDaoImpl {
	
	@Autowired
	AdminDao adminDao;

	@Test(expected=NullPointerException.class)
	public void test() {
	Admin admin=adminDao.login("AD111", "123");
	assertEquals(admin.getAdminid(),"AD111");
	
	Admin admin1=adminDao.login("AD11", "123");
	assertNull(admin1);
	}
}
