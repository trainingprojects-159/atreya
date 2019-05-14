package com.mphasis.atreya.daoimpl;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.atreya.dao.PatientDao;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.exceptions.ClinicExceptions;

@Repository
public class PatientDaoImpl implements PatientDao {
	
		@Autowired
		SessionFactory sessionFactory;

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		public Patient login(String pid,String pwd) throws ClinicExceptions{
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			TypedQuery<Patient> query=session.createQuery("from Patient where pid=:pid and pwd=:pwd");
			query.setParameter("name", pid);
			query.setParameter("pwd",pwd);
			Patient patient=(Patient)query.getSingleResult();
			tr.commit();
			return patient;
		}

		public void register(Patient patient) throws ClinicExceptions{
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.save(patient);		
			tr.commit();
		}
		
		public void deletePatient(String pid) throws ClinicExceptions{
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Patient patient1=(Patient)session.get(Patient.class, pid);
			session.delete(patient1);
			tr.commit();
		}

		public void updatePatient(Patient patient) throws ClinicExceptions{
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.update(patient);
			tr.commit();
		}

		public Patient getById(String pid) throws ClinicExceptions{
			Session session = this.sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Patient patient1=(Patient)session.get(Patient.class, pid);
			tr.commit();
			return patient1;
		}

		public List<Patient> getPatients() throws ClinicExceptions{
			Session session = this.sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			List<Patient> patients=session.createQuery("from Patient", Patient.class).list();
			tr.commit();
			return patients;
		}

		public List<Patient> getPatientByName(String pname) throws ClinicExceptions{
			Session session = this.sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Query<Patient> cri=session.createQuery("from Patient where pname=:pname", Patient.class);
			cri.setParameter("pname", pname);
			List<Patient> patients=cri.list();
			tr.commit();
			return patients;
		}
	}
