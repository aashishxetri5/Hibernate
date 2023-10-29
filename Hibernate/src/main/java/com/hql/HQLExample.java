package com.hql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Student;

public class HQLExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

//		TypedQuery<Student> query = session.createQuery("from Student", Student.class); //HQL => "from Student"
		TypedQuery<Student> query = session.createQuery("from Student where id= :stdId", Student.class);
		query.setParameter("stdId", 211812);
		// HQL => "from Student where id= :stdId"

		List<Student> allStudents = query.getResultList();

		for (Student student : allStudents) {
			System.out.println(student);
		}

	}

}
