package com.learning.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Accounts {

	@Id
	@GeneratedValue
	private int sn;
	private int accountNumber;

	@ManyToOne
	private Employee employee;

	public Accounts() {
		super();
	}

	public Accounts(int sn, int accountNumber, Employee employee) {
		super();
		this.sn = sn;
		this.accountNumber = accountNumber;
		this.employee = employee;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Accounts [sn=" + sn + ", accountNumber=" + accountNumber + ", employee=" + employee + "]";
	}

}
