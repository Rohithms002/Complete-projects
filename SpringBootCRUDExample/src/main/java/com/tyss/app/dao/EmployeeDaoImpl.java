package com.tyss.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tyss.app.model.Employee;
import com.tyss.app.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EmployeeRepository employeerepository;
	
	@Autowired
	JdbcTemplate template;

	@Override
	public void save(Employee employee) {
		employeerepository.save(employee);

	}

	public List<Employee> view() {
		return employeerepository.findAll();
	}

	public int delete(int id) {
		employeerepository.deleteById(id);
		return id;
	}
	
	public void update(Employee employee) {
		employeerepository.save(employee);

	}
	
	public Optional<Employee> findById(Integer id) {
		return employeerepository.findById(id);
		
	}
	public int count(int id, String password) {
		String sql = "select count(*) from employee_table where id=? and password=?";
		int count = (int) template.queryForObject(sql, new Object[] { id, password }, int.class);
		return count;
	}

}
