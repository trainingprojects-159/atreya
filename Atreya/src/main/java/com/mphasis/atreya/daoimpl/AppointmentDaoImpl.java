package com.mphasis.atreya.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.atreya.dao.AppointmentDao;
import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.exceptions.ClinicExceptions;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void requestAppointment(Appointment a) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(a);
		tr.commit();
	}
	
	public void deleteAppointment(String id) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Appointment appointment=(Appointment)session.get(Appointment.class,id);
		session.delete(appointment);
		tr.commit();
	}

	public void updateAppointment(Appointment appointment) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(appointment);
		tr.commit();
	}

	public Appointment getById(String id) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Appointment appointment=(Appointment)session.get(Appointment.class,id);
		tr.commit();
		return appointment;
	}

	public List<Appointment> getAll() throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Appointment> appointments=session.createQuery("from Appointment", Appointment.class).list();
		tr.commit();
		return appointments;
	}

	public List<Appointment> getAppointmentByDoctid(String doctid) throws ClinicExceptions{
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query<Appointment> cri=session.createQuery("from Appointment where doctid=:doctid", Appointment.class);
		cri.setParameter("doctid", doctid);
		List<Appointment> appointments=cri.list();
		tr.commit();
		return appointments;
	}
}