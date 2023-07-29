package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Certificate;
import com.learning.entities.Student;

public class EmbeddedDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		
		Student std1 = new Student();
		std1.setId(211812);
		std1.setName("Joe Biden");
		std1.setAddress("Washington DC");
		
		Certificate certif = new Certificate();
		certif.setTitle("Spring and Hibernate");
		certif.setDuration("2 months");
		certif.setCertifiedBy("Durgesh Tiwari");
		
		std1.setCertificate(certif);
		
		Student std2 = new Student();
		std2.setId(212);
		std2.setName("Donald Trump");
		std2.setAddress("New York");
		
		Certificate certif2 = new Certificate();
		certif.setTitle("Python with Django");
		certif.setDuration("2.5 months");
		certif.setCertifiedBy("Aashish Katwal");
		
		std1.setCertificate(certif2);
		
		Transaction tx = session.beginTransaction();
		session.save(std1);
		session.save(std2);
		
		
		tx.commit();
		session.close();
		factory.close();

	}

}
