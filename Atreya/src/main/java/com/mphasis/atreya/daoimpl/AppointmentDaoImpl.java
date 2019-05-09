package com.mphasis.atreya.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.atreya.dao.AppointmentDao;
import com.mphasis.atreya.entities.Appointment;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void requestAppointment(Appointment a) {
	
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		//System.out.println(a.getAppid());
		session.save(a);
		tr.commit();
	}
	

	public void deleteAppointment(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Appointment appointment=(Appointment)session.get(Appointment.class,id);
		session.delete(appointment);
		tr.commit();
		
	}

	public void updateAppointment(Appointment appointment) {
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(appointment);
		tr.commit();

	}

	public Appointment getById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Appointment appointment=(Appointment)session.get(Appointment.class,id);
		tr.commit();
		return appointment;

	}

	public List<Appointment> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Appointment> appointments=session.createCriteria(Appointment.class).list();
		tr.commit();
		return appointments;
	}

	public List<Appointment> getAppointmentByDoctid(String doctid) {
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Criteria cri=session.createCriteria(Appointment.class);
		cri.add(Restrictions.eq("doctid", doctid));
		List<Appointment> appointments=cri.list();
		tr.commit();
		return appointments;
	}

}
