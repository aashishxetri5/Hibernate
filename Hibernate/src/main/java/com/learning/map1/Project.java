package com.learning.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int pid;
	@Column(name = "project_name")
	private String pname;

	@ManyToMany(mappedBy = "projects")
	private List<Employees> employees;

	public Project() {
		super();
	}

	public Project(int pid, String pname, List<Employees> employees) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.employees = employees;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

}
