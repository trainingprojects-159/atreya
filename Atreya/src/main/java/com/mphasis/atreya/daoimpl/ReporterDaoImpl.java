package com.mphasis.atreya.daoimpl;


import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mphasis.atreya.dao.ReporterDao;
import com.mphasis.atreya.entities.Reporter;


@Repository

public class ReporterDaoImpl implements ReporterDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Reporter login(String repid, String pwd) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		TypedQuery<Reporter> query=session.createQuery("from Reporter where repid=:repid and pwd=:pwd");
		query.setParameter("repid", repid);
		query.setParameter("pwd", pwd);
		Reporter reporter=(Reporter)query.getSingleResult();
		tr.commit();
		return reporter;
	}

	public void insertReporter(Reporter reporter) {
		{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(reporter);
			tr.commit();
		}
	}

	public void deleteReporter(String repid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Reporter r = (Reporter) session.get(Reporter.class,repid);
		session.delete(r);
		tr.commit();
	}

	public void updateReporter(Reporter reporter) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(reporter);
		tr.commit();
	}
}
