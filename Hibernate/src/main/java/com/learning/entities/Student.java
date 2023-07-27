package com.learning.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity // This tells Hibernate to treat this class as an Entity.
//@Table(name="students") //Sets table name in the DB
public class Student {

	@Id // This is used to mark the column as PK
	private int id;
	
	private String name;
	
	private String address;

	public Student() {
		super();
	}

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
