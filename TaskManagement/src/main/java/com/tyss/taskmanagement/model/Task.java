package com.tyss.taskmanagement.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	 Date createdAt = new Date();
	int status=1;
	String assignedBy;
	String search;
}
