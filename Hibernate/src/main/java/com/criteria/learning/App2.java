/**
 * 
 */
package com.criteria.learning;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hql.joins.Book;
import com.learning.entities.Student;

/**
 * @author asus
 */
public class App2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Book> bookQuery = builder.createQuery(Book.class);

		CriteriaQuery<Student> studentQuery = builder.createQuery(Student.class);

		Root<Book> root = bookQuery.from(Book.class);
		Root<Student> rootStudent = studentQuery.from(Student.class);

		bookQuery.select(root).where(builder.like(root.get("title"), "%h%")).orderBy(builder.asc(root.get("bookId")));
		bookQuery.select(root).where(builder.gt(root.get("bookId"), 3));
		bookQuery.select(root).where(builder.lt(root.get("bookId"), 4));
		bookQuery.select(root).where(builder.greaterThanOrEqualTo(root.get("bookId"), 4));

		bookQuery.select(root).where(builder.ge(root.get("bookId"), 4));

//		1. AND, OR, NOT Conditions:
		
		bookQuery.select(root)
			.where(
					builder.and(
							builder.like(root.get("title"), "%h%"),
							builder.equal(root.get("title"), "Atomic Habits")
							)
					);

//		2. IN Condition:

		studentQuery.select(rootStudent).where(rootStudent.get("address").in("Nepal", "Aarubari"));

		TypedQuery<Book> query = session.createQuery(bookQuery);
		List<Book> allBooks = query.getResultList();

		TypedQuery<Student> stdQuery = session.createQuery(studentQuery);
		List<Student> allStudents = stdQuery.getResultList();

		Iterator<Book> iterator = allBooks.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		Iterator<Student> studentIterator = allStudents.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}

		session.close();

	}

}
