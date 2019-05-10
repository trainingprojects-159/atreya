package com.mphasis.atreya.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.atreya.dao.LeaveReportDao;
import com.mphasis.atreya.entities.LeaveReport;


@Repository
public class LeaveReportDaoImpl implements LeaveReportDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void applyLeave(LeaveReport leaveReport) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(leaveReport);
		tr.commit();
		
	}

	public void manageLeave(LeaveReport leaveReport) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(leaveReport);
		tr.commit();
		session.close();
	}

}
