package com.learning.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	private int empId;
	private String name;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY) //by default fetch is lazy
	private List<Accounts> empAccount;

	public Employee() {
		super();
	}

	public Employee(int empId, String name, List<Accounts> empAccount) {
		super();
		this.empId = empId;
		this.name = name;
		this.empAccount = empAccount;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Accounts> getEmpAccount() {
		return empAccount;
	}

	public void setEmpAccount(List<Accounts> empAccount) {
		this.empAccount = empAccount;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
