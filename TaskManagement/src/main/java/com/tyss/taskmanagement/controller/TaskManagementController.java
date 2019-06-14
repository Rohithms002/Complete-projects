package com.tyss.taskmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.taskmanagement.dao.TaskDao;
import com.tyss.taskmanagement.model.Employee1;
import com.tyss.taskmanagement.model.Task;
import com.tyss.taskmanagement.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class TaskManagementController {
	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	JavaMailSender mailsender;

	@Autowired
	TaskDao dao;

	@PostMapping(path = "/employeeregistration")
	public String saveRest(@RequestBody Employee1 employee) {
		if (employee.getPassword().equals(employee.getConfirmPassword())) {
			repo.save(employee);
			return "sucessfully registered";
		} else {
			return "password did not match";
		}
	}

	@PostMapping(path = "/employeelogin")
	public String login(@RequestBody Employee1 employee, HttpServletRequest request) {
		HttpSession session1 = request.getSession(true);
		session1.setAttribute("name", employee.getEmail());
		int count = dao.getcount(employee.getEmail(), employee.getPassword());
		if (count == 1) {
			return "login success";
		} else {
			return "invalid login credentials";
		}
	}

	@PostMapping(path = "/createtask")
	public String createtask(@RequestBody Task task, HttpServletRequest request) {
		HttpSession session1 = request.getSession(false);
		int count = dao.userEmailExists(task.getAssignTo());
		if (session1 != null || count == 1) {
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("${spring.mail.username}");
			mailMessage.setTo(task.getAssignTo());
			mailMessage.setSubject(task.getCategory());
			mailMessage.setText(task.getDescription());
			mailsender.send(mailMessage);
			String email = (String) session1.getAttribute("name");

			task.setAssignedBy(email);
			dao.save(task);
			return "task created";

		} else {

			return "session expired";

		}
	}

	@GetMapping("/gettome")
	public ResponseEntity<?> geToMe(HttpServletRequest request) {

		HttpSession session1 = request.getSession(false);
		String email = (String) session1.getAttribute("name");
		ResponseEntity<?> response = new ResponseEntity<>(dao.getAssignedTo(email), HttpStatus.OK);
		return response;
	}

	@GetMapping("/getbyme")
	public ResponseEntity<?> getByMe(HttpServletRequest request) {
		HttpSession session1 = request.getSession(false);
		String email = (String) session1.getAttribute("name");
		ResponseEntity<?> response = new ResponseEntity<>(dao.getAssignedBy(email), HttpStatus.OK);
		return response;
	}

	@GetMapping("/showcompleted")
	public ResponseEntity<?> showCompleted(HttpServletRequest request) {
		ResponseEntity<?> response = new ResponseEntity<>(dao.getCompleted(), HttpStatus.OK);
		return response;
	}

	@GetMapping("/search")
	public ResponseEntity<?> search() {
		ResponseEntity<?> response = new ResponseEntity<>(dao.search(), HttpStatus.OK);
		return response;
	}

	@PostMapping("/accept")
	public String accepttask() {

		return "status changed";
	}

}
