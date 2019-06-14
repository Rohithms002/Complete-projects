package com.tyss.taskmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class ToDoTask {
	@Id
	Integer id;
	@Column(name ="description_column")
	String description;
	String priority;
	String assignTo;
	@Column(name ="date_column")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date date;
	@Column(name ="category_column")
	String category;
	@Column(name ="addcategory_column")
	String addCategory;
	@Column(name="assigned_to_email")
	String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	 Date taskCreatedAt;
	int status;
	String assignedBy;
	String comments;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
  Date taskMovedAt = new Date();
	String addComments;
	
	
}
