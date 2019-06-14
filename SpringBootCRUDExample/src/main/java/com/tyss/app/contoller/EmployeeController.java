package com.tyss.app.contoller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.app.dao.EmployeeDaoImpl;
import com.tyss.app.model.Employee;
import com.tyss.app.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDaoImpl employeedaoimpl;

	@Autowired
	EmployeeRepository employeerepository;

	@GetMapping("/register")
	public String employeeform(Map<String, Object> map) {
		map.put("employee", new Employee());
		return "registration";

	}

	@RequestMapping("/registered")
	public String save(@ModelAttribute("employee") Employee employee) {
		employeedaoimpl.save(employee);
		return "success";
	}

	@RequestMapping("/view")
	public String view(Map<String, Object> map,Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		System.out.println(id);
		if(id!= null) {
		List<Employee> list = employeedaoimpl.view();
		model.addAttribute("list", list);
		return "viewemployee";
		}
		else {
			session.invalidate();
			model.addAttribute("message", "!!your session has expired, please login again to continue!!");
			map.put("employee", new Employee());
			return "loginform";
		}

	}

	@RequestMapping("/deleteemp")
	public String delete(@RequestParam Integer id, Model model, @ModelAttribute("employee") Employee employee) {
		String msg = "";
		try {
			employeedaoimpl.delete(id);
			msg = "you have successfully deleted employee details with" + id;
		} catch (Exception e) {
			msg = "Already deleted with id :" + id;
		}
		model.addAttribute("message", msg);
		List<Employee> list = employeedaoimpl.view();
		model.addAttribute("list", list);
		return "viewemployee";
	}

	@RequestMapping("/editemp")
	public String edit(Map<String, Object> map,Model model, @RequestParam Integer id,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer id1 = (Integer) session.getAttribute("id");
		System.out.println(id1);
		if(id!= null) {
		Optional<Employee> employee = employeedaoimpl.findById(id);
		model.addAttribute("command", employee);
		return "employeeeditform";
		}else {
			session.invalidate();
			model.addAttribute("message", "!!your session has expired, please login again to continue!!");
			map.put("employee", new Employee());
			return "loginform";
		}

	}

	@RequestMapping(value = "/update")
	public String updateUser(Model model, @ModelAttribute("employee") Employee employee) {
		employeedaoimpl.update(employee);
		List<Employee> list = employeedaoimpl.view();
		model.addAttribute("list", list);
		return "viewemployee";
	}

	@RequestMapping("/loginform")
	public String loginform(Map<String, Object> map) {
		map.put("employee", new Employee());
		return "loginform";
	}

	@RequestMapping("/validate")
	public String validate(@ModelAttribute("employee") Employee employee, HttpServletRequest request, HttpServletResponse response ) {
		HttpSession session = request.getSession(true);
		session.setAttribute("id", employee.getId());
		int count = employeedaoimpl.count(employee.getId(), employee.getPassword());
		if (count == 0) {
			return "registration";
		} else {
			return "welcome";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	 HttpSession session = request.getSession(false);
	 session.invalidate();
		return "logout";
	}
}
