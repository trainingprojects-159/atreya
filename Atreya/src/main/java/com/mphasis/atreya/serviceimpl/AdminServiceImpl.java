package com.mphasis.atreya.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.atreya.dao.AdminDao;
import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService  {

	@Autowired
	AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public Admin register(String adminid, String pwd) throws ClinicExceptions
	{
		Admin admin = null;
		if(adminid != null && adminid.matches("[AD][0-9]{5}"))
		{
			if(pwd != null && pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				admin=adminDao.login(adminid, pwd);
			}
			else 
			{
				throw new ClinicExceptions("Entered pwd is invalid");
			}
		}
		else 
		{
			throw new ClinicExceptions("Entered adminid " + adminid + " is invalid");
		}
		return admin;
	}
}

