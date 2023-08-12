package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Certificate;
import com.learning.entities.Student;

public class ObjectStates {

	public static void main(String[] args) {
		/*
		 * Object States: a. Transient b. Persistent c. Detached d. Removed
		 **/

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student std1 = new Student();
		std1.setId(211802);
		std1.setName("Sonish");
		std1.setAddress("Nepal");
		std1.setCertificate(new Certificate("React JS", "2", "Janak K. Lal"));
//		The std1 object is in transient state.

		Session session = factory.openSession();
		session.save(std1);
//		Now the std1 is in persistent state because it is associated to session and DB.

		/*
		 * If any changes is done in the object at this section after saving to session
		 * and before committing to the transaction, The changes are reflected in DB as
		 * the object is in persistent state.
		 */
		Transaction tx = session.beginTransaction();

//		session.delete(std1);
		tx.commit();
		session.close();

		/*
		 * If any changes is done in the object at this section after saving to session
		 * and committing to the transaction, The changes aren't reflected in DB as the
		 * object is in detached state.
		 * 
		 * Now, if we delete the session using session.delete(), the data inserted will
		 * also be deleted after the transaction has been committed.
		 */

		factory.close();
	}

}
