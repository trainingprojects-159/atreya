package com.mphasis.atreya.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.atreya.dao.AdminDao;
import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	 public Admin register(String adminid, String pwd) {
		 return adminDao.login(adminid, pwd);
	}

}
