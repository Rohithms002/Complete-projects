package com.tyss.taskmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Employee1 {

	@Id
	@GeneratedValue
	int id;
	@NotNull
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@NotNull
	@Column(name="contact_no")
	long contactNo;
	@NotNull
	@Column(name="user_email")
	String email;
	@NotNull
	@Column(name="employee_password")
	String password;
	@NotNull
	@Column(name="confirm_password")
	String confirmPassword;
}
