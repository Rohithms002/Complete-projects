package com.tyss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tyss.model.Employee;

@Repository
public class EmployeeDaoimpl implements EmpDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee p) {
		String sql = "insert into Employee_details(name,salary,designation,email,password) values('" + p.getName()
				+ "'," + p.getSalary() + ",'" + p.getDesignation() + "', '" + p.getEmail() + "', '" + p.getPassword()
				+ "')";
		System.out.println("inserting" + sql);
		return template.update(sql);
	}
	
	public int saveroll(Employee p) {
		String sql="insert into roll_details(roll_type) values('"+p.getRollType() + "')";
		return template.update(sql);
		
	}

	public int update(Employee p) {
		String sql = "update Employee_details set name='" + p.getName() + "', salary='" + p.getSalary()
				+ "',designation='" + p.getDesignation() + "', email='" + p.getEmail() + "', password='"
				+ p.getPassword() + "' where id=" + p.getId() + "";

		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from Employee_details where id=" + id + "";
		return template.update(sql);
	}

	public Employee getEmpById(int id) {
		String sql = "select * from Employee_details where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public int getCount(int id, String password) {
		String sql = "select count(*) from Employee_details where id=? and password=?";
		int count = (int) template.queryForObject(sql, new Object[] { id, password }, int.class);
		return count;

	}

	public int fetchid(String name, String email) {
		String sql = "select id from Employee_details where name =? and email=?";
		int id1 = (int) template.queryForObject(sql, new Object[] { name, email }, int.class);
		return id1;
	}

	public int fetchcount(int id, String email) {

		String sql = "select count(*) from Employee_details where id=? and email=?";
		int count = (int) template.queryForObject(sql, new Object[] { id, email }, int.class);
		return count;

	}

	public List<Employee> getEmployees() {
		return template.query("select * from Employee_details", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDesignation(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPassword(rs.getString(6));
				return e;
			}
		});
	}
}