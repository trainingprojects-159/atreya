package com.mphasis.atreya.daoimpl;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.atreya.dao.AdminDao;
import com.mphasis.atreya.entities.Admin;



@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	SessionFactory sessionFactory;
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Admin login(String adminid, String pwd) 
	{
		Session session=sessionFactory.openSession();
		TypedQuery<Admin> query=session.createQuery("from Admin where adminid=:adminid and pwd=:pwd");
		   query.setParameter("adminid", adminid);
		   query.setParameter("pwd",pwd);
		   Admin admin=(Admin) query.getSingleResult();
		   return admin;
	}
}