package com.mphasis.atreya.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.atreya.dao.FeedbackDao;
import com.mphasis.atreya.entities.Feedback;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
    SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void createFedback(Feedback feedback) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(feedback);
		tr.commit();
	}
}