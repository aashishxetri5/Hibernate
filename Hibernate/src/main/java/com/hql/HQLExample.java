package com.hql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Student;

public class HQLExample {

	public static void main(String[] args) throws HibernateException{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

//		TypedQuery<Student> query = session.createQuery("from Student", Student.class); //HQL => "from Student"
		TypedQuery<Student> query = session.createQuery("from Student where id= :stdId", Student.class);
		query.setParameter("stdId", 211812);
		// HQL => "from Student where id= :stdId"

		List<Student> allStudents = query.getResultList();

		for (Student student : allStudents) {
			System.out.println(student);
		}
		
		System.out.println("----------------------------------------");
		
		@SuppressWarnings("deprecation")
		Query<Student> deleteQuery = session.createQuery("delete from Student where id= :studentId");
		deleteQuery.setParameter("studentId", 211802);
		
		int r = deleteQuery.executeUpdate();
		System.out.println("Deleted " + r);
		
		
		tx.commit();
		session.close();
		factory.close();

	}

}
