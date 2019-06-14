package com.tyss.dao;

import java.util.List;

import com.tyss.model.Employee;

public interface EmpDao {

	public int save(Employee p);

	public int update(Employee p);

	public int delete(int id);

	public Employee getEmpById(int id);

//	public String fetchpassword(int id);
	public int fetchid(String name, String email);

	public List<Employee> getEmployees();

	public int getCount(int id, String password);
}
