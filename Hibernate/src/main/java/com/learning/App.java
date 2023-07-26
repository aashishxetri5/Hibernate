package com.learning;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		//session factory is a thread safe object. So, only one of this should be created.
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		System.out.println(factory);
	}
}
