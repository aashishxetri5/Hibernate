package com.learning;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.mapping.Accounts;
import com.learning.mapping.Employee;

public class ManyToOneMapper {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Employee emp = new Employee();
		emp.setEmpId(211812);
		emp.setName("John Doe");
		
		Accounts acc1 = new Accounts();
		Accounts acc2 = new Accounts();
		
		acc1.setAccountNumber(2189442);
		acc1.setEmployee(emp);
		acc2.setAccountNumber(8758932);
		acc2.setEmployee(emp);

		List<Accounts> accNum = new ArrayList<Accounts>();
		
		accNum.add(acc1);
		accNum.add(acc2);
		
		emp.setEmpAccount(accNum);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		session.save(acc1);
		session.save(acc2);

//		Fetching Data
		Employee empl = (Employee) session.get(Employee.class, 211812);
		System.out.println(empl.getEmpAccount());
		
		for (Accounts a: empl.getEmpAccount()) {
			System.out.println(a.getAccountNumber());
		}
		
		tx.commit();
		
		session.clear();
		factory.close();
	}

}
