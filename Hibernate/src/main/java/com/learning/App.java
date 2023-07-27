package com.learning;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Student;

public class App {
	public static void main(String[] args) {
		// session factory is a thread safe object. So, only one of this should be
		// created.
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student std = new Student();
		std.setId(2011);
		std.setName("Aashish Katwal");
		std.setAddress("Kathmandu");

		System.out.println(std);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(std);

		tx.commit();

		session.close();

		factory.close();
	}
}
