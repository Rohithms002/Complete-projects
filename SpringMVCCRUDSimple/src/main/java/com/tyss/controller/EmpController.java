package com.tyss.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.dao.EmployeeDaoimpl;
import com.tyss.model.Employee;

@Controller
public class EmpController {
	@Autowired
	EmployeeDaoimpl dao;

	private static final Logger logger = Logger.getLogger(EmpController.class);

	@RequestMapping("/empform")
	public String showform(Model model) {
		model.addAttribute("command", new Employee());
		logger.info("empform opened.");
		return "empform";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Employee employee, Model model) {
		String encryptedpassword = "";
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(employee.getPassword().getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			encryptedpassword = no.toString(16);
			while (encryptedpassword.length() < 32) {
				encryptedpassword = "0" + encryptedpassword;
			}

		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		employee.setPassword(encryptedpassword);
		

		dao.save(employee);
		dao.saveroll(employee);
		int id1 = dao.fetchid(employee.getName(), employee.getEmail());
		model.addAttribute("message",
				"your unique Id generated is " + id1 + " use your unique id to login to the application");
		logger.error("message");
		logger.info("saving an employee started");
		return "saved";
	}

	@RequestMapping("/viewemp")
	public String viewemp(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("name") == null) {

			model.addAttribute("message", "Your Session has expired. Please login first to continue");
			return "loginform";

//			logger.info("Viewmemp displayed.");

			// logs debug message
//			if (logger.isDebugEnabled()) {
//				logger.debug("Inside:  viewemp" + "" + "");
//			}
//			// logs exception
//			logger.error("Logging a sample exception", new Exception("Testing"));

		} else {
			String name = (String) session.getAttribute("name");
			System.out.println(name);
			List<Employee> list = dao.getEmployees();
			model.addAttribute("list", list);
			return "viewemp";

		}

	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model model) {
		Employee employee = dao.getEmpById(id);
		model.addAttribute("command", employee);
		return "empeditform";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editsave(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("emp") Employee employee, Model model) {
		System.out.println("saved");

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		System.out.println(name);
		if (session.getAttribute("name") != null) {

			dao.update(employee);
			return "redirect:/viewemp";
		} else {
			session.invalidate();
			model.addAttribute("message", "your session has expired, please login again to continue");
			return "loginform";
		}

	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, HttpServletResponse response, @PathVariable int id, Model model,
			Employee employee) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("name") == null) {

			model.addAttribute("message", "Your Session has expired. Please login first to continue");
			return "loginform";
		} else {
			dao.delete(id);
			model.addAttribute("message", "deleted");
			return "redirect:/viewemp";
		}

	}

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("loginform");
		return "loginform";
	}

	@RequestMapping(value = "/logoutpage")
	public String displayLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "logoutpage";

	}

	@RequestMapping(value = "/loginemp", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam int id, Model model,
			@ModelAttribute("com.tyss.moodel.Employee") Employee employee) {
		HttpSession session = request.getSession(true);
		session.setAttribute("name", "name");
		System.out.println(employee.getName());
		System.out.println("name");
		String encryptedpassword = "";
		try {
			String encryptedpasssword = employee.getPassword();
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(encryptedpasssword.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			encryptedpassword = no.toString(16);
			while (encryptedpasssword.length() < 32) {
				encryptedpasssword = "0" + encryptedpasssword;
			}

		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		employee.setPassword(encryptedpassword);

		int count = dao.getCount(employee.getId(), employee.getPassword());
		if (count == 0) {
			model.addAttribute("error", "invalid login credentials");
			return "loginform";
		} else
			model.addAttribute("command", "Hi User" + employee.getId());
		System.out.println(encryptedpassword);
		return "welcome";

	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String forgot() {
		return "redirect:/forgot";
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String ForgotPassword(Model model, Employee employee) {
		int count = dao.fetchcount(employee.getId(), employee.getEmail());
		if (count == 0) {
			model.addAttribute("message", "please enter a valid id and email");
		} else {
			return "changepwd";
		}
		return "forgot";
	}

}