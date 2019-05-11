package com.mphasis.atreya.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.atreya.dao.LeaveReportDao;
import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.exceptions.ClinicExceptions;


@Repository
public class LeaveReportDaoImpl implements LeaveReportDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void applyLeave(LeaveReport leaveReport) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(leaveReport);
		tr.commit();		
	}

	public void manageLeave(LeaveReport leaveReport) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(leaveReport);
		tr.commit();
		session.close();
	}
}