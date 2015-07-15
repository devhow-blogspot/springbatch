package com.devhow.springbatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.devhow.springbatch.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee em = new Employee();
		em.setCreationdate(rs.getDate("creationDate"));
		em.setEmail(rs.getString("email"));
		em.setFirst_name(rs.getString("first_name"));
		em.setId(rs.getLong("id"));
		em.setLanguage(rs.getString("language"));
		em.setLast_name(rs.getString("last_name"));
		em.setPhone(rs.getString("phone"));
		em.setUpdatedate(rs.getDate("updateDate"));
		return em;
	}
}
