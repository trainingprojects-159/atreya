package com.mphasis.atreya.service;

import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface AdminService {
	 public Admin register(String adminid,String pwd) throws ClinicExceptions;
}
