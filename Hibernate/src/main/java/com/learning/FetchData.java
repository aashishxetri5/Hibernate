package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Address;
import com.learning.entities.Student;

public class FetchData {

	public static void main(String[] args) {
		//Get
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Address addr = (Address) session.get(Address.class, 10);
		System.out.println(addr);
		
		Student std = (Student) session.load(Student.class, 3);
		System.out.println(std);
		
		session.close();
		factory.close();

	}

}
