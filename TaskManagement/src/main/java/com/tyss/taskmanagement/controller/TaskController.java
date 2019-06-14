package com.tyss.taskmanagement.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.taskmanagement.dao.TaskDao;
import com.tyss.taskmanagement.model.Employee1;
import com.tyss.taskmanagement.model.Task;
import com.tyss.taskmanagement.model.ToDoTask;
                                          
@Controller
public class TaskController {

	@Autowired
	TaskDao dao;

	@GetMapping("/createtask1")
	public String createTask(Map<String, Object> map) {
		map.put("task", new Task());
		return "taskdashboard";

	}

	@GetMapping("/createtask")
	public String createtask1(Map<String, Object> map) {
		map.put("task", new Task());
		return "createtask";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("task") Task task, HttpServletRequest request) {
		HttpSession session1 = request.getSession(false);
		if (session1 != null) {
			String email = (String) session1.getAttribute("name");
			task.setAssignedBy(email);
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			// get Session
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("rohithms002@gmail.com", "pushpaprasad");
				}
			});
			// compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(task.getAssignTo()));
				message.setSubject(task.getDescription());
				message.setText(task.getDescription());
				// send message
				Transport.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dao.save(task);
			return "taskdashboard";
		} else {
			return "login";
		}
	}

	@GetMapping("/register")
	public String register(Map<String, Object> map) {
		map.put("employee", new Employee1());
		return "Employeeregistration";
	}
	
	
	

	@PostMapping("/saveemployee")
	public String saveemployee(Map<String, Object> map, Model model, @ModelAttribute("employee") Employee1 employee) {
		if (employee.getPassword().equals(employee.getConfirmPassword())) {
			dao.saveemployee(employee);
			return "success";
		} else {
			map.put("employee", new Employee1());
			model.addAttribute("message", "password did not match,please re-enter");
			return "Employeeregistration";
		}

	}

	@GetMapping("/login")
	public String login(Map<String, Object> map) {
		map.put("employee", new Employee1());
		return "login";
	}

	@PostMapping("/checklogin")
	public String checklogin(@ModelAttribute("employee") Employee1 employee, HttpServletRequest request, Model model) {

		HttpSession session1 = request.getSession(true);

		String page = "";
		int count = dao.getcount(employee.getEmail(), employee.getPassword());
		if (count == 1) {
			String email = employee.getEmail();
			session1.setAttribute("name", email);
			page = "taskdashboard";
		} else {
			model.addAttribute("error", "!!Invalid Credentials!!");
			model.addAttribute("employee", new Employee1());
			page = "login";
		}
		return page;
	}

	@GetMapping("/assignedtome")
	public String listAll(Model model, @ModelAttribute("employee") Employee1 employee, HttpServletRequest request) {

		HttpSession session1 = request.getSession(false);
		String email = (String) session1.getAttribute("name");

		List<Task> list = dao.getAssignedTo(email);
		model.addAttribute("list", list);

		return "assignedtome";
	}

	@GetMapping("/assignedbyme")
	public String displayAll(Model model, @ModelAttribute("employee") Employee1 employee, HttpServletRequest request) {
		HttpSession session1 = request.getSession(false);
		String email = (String) session1.getAttribute("name");

		List<Task> list = dao.getAssignedBy(email);
		model.addAttribute("list", list);

		return "assignedbyme";
	}

	@GetMapping("/completedtask")
	public String showAllTask(Model model) {
		List<Task> list = dao.getCompleted();
		model.addAttribute("list", list);
		return "completedtask";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session1= request.getSession(false);
		session1.invalidate();
		return "logout";
	}
	
	@GetMapping("/open")
	public String open(@ModelAttribute("task") Task task ,@RequestParam Integer id, Model model) {
		Optional<Task> task1 = dao.findById(id);
		model.addAttribute("command", task1);
		return "taskaccept";
	}
	@PostMapping("/accept")
	public String acceptTask(@ModelAttribute("task") Task task) {
			task.setStatus(2);
			dao.acceptTask(task);
			return "taskdashboard";
	}
	
	@GetMapping("/movetocomplete")
	public String move(@ModelAttribute("task") Task task ,@RequestParam Integer id, Model model) {
		Optional<Task> task1 = dao.findById(id);
		model.addAttribute("command", task1);
		return "movetocomplete";
	}
	
	@PostMapping("/move")
	public String moveToComplete(@ModelAttribute("task") Task task) {
		task.setStatus(3);
		dao.acceptTask(task);
		return "taskdashboard";
	}
	
	@GetMapping("/todo")
	public String todo(@ModelAttribute("task") Task task, Model model, HttpServletRequest request) {
		HttpSession session1= request.getSession(false);
		String email= (String)session1.getAttribute("name");
		List<Task> list = dao.getToDo(email);
		model.addAttribute("list", list);
		return "todo";
	}
	
	@GetMapping("/inprogress")
	public String inProgress(@ModelAttribute("task") Task task, Model model, HttpServletRequest request) {
		HttpSession session1= request.getSession(false);
		String email= (String)session1.getAttribute("name");
		List<Task> list = dao.getInProgress(email);
		model.addAttribute("list", list);
		return "inprogress";
	}

	@GetMapping("/blocked")
	public String blocked(@ModelAttribute("task") Task task, Model model, HttpServletRequest request) {
		List<Task> list = dao.getBlocked();
		model.addAttribute("list", list);
		return "completedtask";
	}
	
	@GetMapping("/addcomment")
	public String addcomments(Map<String, Object> map,@RequestParam Integer id, @ModelAttribute("todotask") ToDoTask todotask) {
		Optional<ToDoTask> todotask1=dao.getById(id);
		map.put("comments", todotask1);
		return "addcomment";
		
		
		
	}
	
	@PostMapping("/commentadded")
	public String addedComment(@ModelAttribute("todotask") ToDoTask todotask) {
		String comments1=todotask.getAddComments();
		todotask.setAddComments(null);
		todotask.setComments(comments1); 
		dao.savecomment(todotask);
		return "inprogress";
	}
	
	@RequestMapping("/showsearch")
	public String searchform(Map<String, Object> map) {
		map.put("task", new Task());
		return "search";
	}
	
	@RequestMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute("task") Task task){
		String searchstring= task.getSearch();
		ResponseEntity<?> response = new ResponseEntity<>(dao.search(),HttpStatus.OK);
		return response;
	}
	
}
