package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.joins.Book;

public class FirstLevelCache {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		/*
		 * When the get method is called, Hibernate stores the object in the cache and
		 * when same object is fetched, it brings the object from the cache memory
		 * instead of firing the query again.
		 */
		Book book1 = session.get(Book.class, 3);
		System.out.println(book1);

		System.out.println("Some other tasks are happening..");

		Book book2 = session.get(Book.class, 3);
		System.out.println(book2);

		System.out.println(session.contains(book2)); // true, because the object is in the session.

		/*
		 * After the session is closed, the object(s) in the cache are
		 * destroyed/removed.
		 */
		session.close();
		factory.close();

	}

}
