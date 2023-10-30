package com.hql.joins;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLJoins {
	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}

		return factory;
	}

	public static void populateData() {
//		Books by author 1
		Author a1 = new Author();
		a1.setName("James Clear");

		Book b1 = new Book("Atomic Habits", a1);
		Book b2 = new Book("The Clear Habit Journal", a1);

		List<Book> allBooks = new ArrayList<Book>();
		allBooks.add(b1);
		allBooks.add(b2);

		a1.setAllBooks(allBooks);

//		Books by Author 2
		Author a2 = new Author();
		a2.setName("William Stalling");

		Book b3 = new Book("Crypto and Security", a2);
		Book b4 = new Book("Data and Computer", a2);

		List<Book> allBooks2 = new ArrayList<Book>();
		allBooks2.add(b3);
		allBooks2.add(b4);

//		Books by author 3
		Author a3 = new Author();
		a3.setName("Eric Barker");

		Book b5 = new Book("Barking up the wrong tree", a3);
		Book b6 = new Book("Play well with others", a3);

		List<Book> allBooks3 = new ArrayList<Book>();
		allBooks2.add(b5);
		allBooks2.add(b6);

		a3.setAllBooks(allBooks3);

		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(a1);
		session.save(b1);
		session.save(b2);

		session.save(a2);
		session.save(b3);
		session.save(b4);

		session.save(a3);
		session.save(b5);
		session.save(b6);

		tx.commit();
		session.close();

	}

	public static void simpleJoin() {
		Session session = getFactory().openSession();

		/*
		 * We use variable name from the respective class instead of column name from
		 * the table
		 */
		String simpleJoinQuery = "SELECT b.title, a.name FROM Book b JOIN b.author a";

		Query q = session.createQuery(simpleJoinQuery);

		// List<Book> allBooks = q.list();
		List<Object[]> results = q.list();

		for (Object[] result : results) {
			System.out.println("--------------------------------------------");
			String bookTitle = (String) result[0];
			String authorName = (String) result[1];

			System.out.println(bookTitle + "\t" + authorName);
		}
		session.close();
	}
	
	public static void innerJoin() {
		Session session = getFactory().openSession();
		
		String leftJoinQuery = "SELECT b, a from Book b LEFT JOIN b.author a";
		
		Query q = session.createQuery(leftJoinQuery);
		
		List<Object []> results = q.list();
		
		for(Object[] result: results) {
			System.out.println("--------------------------------------------");
			Book book = (Book) result[0];
			Author author = (Author) result[1];
			
			System.out.println(book + "\t" +  author);
		}
		
		session.close();
		
	}

	public static void main(String[] args) {
//		populateData();
//		simpleJoin();
		innerJoin();
		closeFactory();
	}

	public static void closeFactory() {
		if (factory != null) {
			factory.close();
		}
	}

}
