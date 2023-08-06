package com.learning.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Employees emp1 = new Employees();
		Employees emp2 = new Employees();

		emp1.setEid(10);
		emp1.setName("John Doe");

		emp2.setEid(11);
		emp2.setName("Hammer Swift");

		Project p1 = new Project();
		Project p2 = new Project();

		p1.setPid(1);
		p1.setPname("Pustakalaya");

		p2.setPid(2);
		p2.setPname("Web Scraping");

		List<Employees> employees = new ArrayList<Employees>();
		employees.add(emp1);
		employees.add(emp2);

		List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);

		emp1.setProjects(projects);
		emp2.setProjects(projects);
		p2.setEmployees(employees);
		p2.setEmployees(employees);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		
		session.close();
		factory.close();
	}

}
