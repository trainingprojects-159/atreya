package com.mphasis.atreya.dao;

import com.mphasis.atreya.entities.Admin;

public interface AdminDao {
	public Admin login(String adminid, String pwd);
}
