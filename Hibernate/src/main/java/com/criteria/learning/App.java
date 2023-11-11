package com.criteria.learning;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hql.joins.Book;
import com.hql.joins.HQLJoins;

/**
 * @author asus
 */
public class App {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HQLJoins.getFactory().openSession();

		Criteria cr = session.createCriteria(Book.class);

//		cr.add(Restrictions.eq("title", "Atomic Habits"));
//		cr.add(Restrictions.like("title", "%h%"));
		cr.add(Restrictions.gt("bookId", 2));
		cr.add(Restrictions.lt("bookId", 3));

		List<Book> allBooks = cr.list();

		Iterator<Book> bookIterator = allBooks.iterator();
		while (bookIterator.hasNext()) {
			System.out.println(bookIterator.next());
		}

		session.close();
		HQLJoins.closeFactory();
	}

}
