/**
 * 
 */
package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.joins.Book;

/**
 * 
 */
public class SecondLevelCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session1 = factory.openSession();

		Book book1 = session1.get(Book.class, 2);
		System.out.println(book1);

		session1.close();

		Session session2 = factory.openSession();

		Book book2 = session2.get(Book.class, 2);
		System.out.println(book2);

		session2.close();

		/*
		 * The query is fired only once even though the object was fetched in different
		 * session. This is because of the second level caching.
		 */

		factory.close();

	}

}
