package com.mphasis.atreya.dao;

import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface AdminDao {
	public Admin login(String adminid, String pwd) throws ClinicExceptions;
}
