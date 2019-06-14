package com.tyss.app.model;

import lombok.Data;

@Data
public class Email {
	
	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;
	private String fileName;
}
