package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entities.Answer;
import com.learning.entities.Question;

public class mapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		Question-1
		Answer ans1 = new Answer();
		ans1.setAid(21);
		ans1.setAnswer("James Gosling");
		
		Question q1 = new Question();
		q1.setQid(100);
		q1.setQuestion("Who created Java?");
		q1.setAnswer(ans1);

		ans1.setQuestion(q1);
		
//		Question-2
		Answer ans2 = new Answer();
		ans2.setAid(44);
		ans2.setAnswer("1995");

		Question q2 = new Question();
		q2.setQid(200);
		q2.setQuestion("When was Java created?");
		q2.setAnswer(ans2);
		
		ans2.setQuestion(q2);

//		Opening Session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(q2);
		session.save(ans1);
		session.save(ans2);

		tx.commit();

		session.close();
		factory.close();

	}

}
