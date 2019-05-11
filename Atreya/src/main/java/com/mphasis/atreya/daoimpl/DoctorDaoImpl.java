package com.mphasis.atreya.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.atreya.dao.DoctorDao;
import com.mphasis.atreya.entities.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertDoctor(Doctor doctor) {
		Session session=sessionFactory.openSession();
		session.save(doctor);
	}

	public void deleteDoctor(String doctid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Doctor d=(Doctor)session.get(Doctor.class, doctid);
		session.delete(d);
		tr.commit();
	}

	public void updateDoctor(Doctor doctor) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(doctor);
		session.close();
		tr.commit();
	}

	public Doctor getById(String doctid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Doctor d=(Doctor)session.get(Doctor.class, doctid);
		tr.commit();
		return d;
	}

	public List<Doctor> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Doctor> doctors=session.createQuery("from Doctor", Doctor.class).list();
		tr.commit();
		return doctors;
	}

	public Doctor login(String doctname, String pwd) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tr=session.beginTransaction();
		TypedQuery<Doctor> query=session.createQuery("from Doctor where doctname=:doctname and pwd=:pwd");
		query.setParameter("doctname", doctname);
		query.setParameter("pwd", pwd);
		Doctor doctor=(Doctor) query.getSingleResult();
		tr.commit();
		return doctor;
	}
}
