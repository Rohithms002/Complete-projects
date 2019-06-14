package com.tyss.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Employee {
	private int id;
	private String name;
	private String Password;
	private int salary;
	private String designation;
	private String email;
	private String rollType;

//	public String getPassword() {
//		return Password;
//	}
//
//	public void setPassword(String password) {
//		Password = password;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public float getSalary() {
//		return salary;
//	}
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
//
}