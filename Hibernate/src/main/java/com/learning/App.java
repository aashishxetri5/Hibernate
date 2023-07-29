package com.learning;

import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Address;
//import com.learning.entities.Student;

public class App {
	public static void main(String[] args) throws IOException {
		// session factory is a thread safe object. So, only one of this should be
		// created.
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		Student std = new Student();
//		std.setId(2011);
//		std.setName("Aashish Katwal");
//		std.setAddress("Kathmandu");

		Address address = new Address();
		address.setStreet("Pashupati Road");
		address.setCity("Kathmandu");
		address.setRating(4.5);
		address.setDateAdded(new Date());

//		Reading image
		FileInputStream fis = new FileInputStream("src/main/java/code.jpg");
		byte[] imgData = new byte[fis.available()];
		fis.read(imgData);
		address.setImage(imgData);
		fis.close();
		System.out.println(address);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(address);

		tx.commit();

		session.close();

		factory.close();
	}
}
