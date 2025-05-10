package com.khadri.spring.employee.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.khadri.spring.employee.config.query.constants.Queries;
import com.khadri.spring.employee.form.EmployeeForm;

@Repository
public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public EmployeeForm findById(int id) {
		System.out.println("EmployeeDao : findById(-)");
		return jdbcTemplate.queryForObject(Queries.FIND_BY_ID.getQuery(),
				new BeanPropertyRowMapper<>(EmployeeForm.class), id);
	}
	
	public List<EmployeeForm> findByName(String name) {
		System.out.println("EmployeeDao : findByName(-)");
		return jdbcTemplate.query(Queries.FIND_BY_NAME.getQuery(), new BeanPropertyRowMapper<>(EmployeeForm.class),
				name);
	}

	public List<EmployeeForm> findBySalary(double salary) {
		System.out.println("EmployeeDao : findBySalary(-)");
		return jdbcTemplate.query(Queries.FIND_BY_SALARY.getQuery(), new BeanPropertyRowMapper<>(EmployeeForm.class),
				salary);
	}


	public EmployeeForm save(EmployeeForm employee) {
		System.out.println("EmployeeDao : save(-)");

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(Queries.INSERT.getQuery(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			return ps;
		};

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int result = jdbcTemplate.update(creator, keyHolder);

		if (result == 1) {
			employee.setId(keyHolder.getKey().intValue());
		}

		return employee;
	}
	public EmployeeForm update(EmployeeForm employee) {
		System.out.println("EmployeeDao : update(-)");

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(Queries.UPDATE.getQuery());
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setInt(3, employee.getId());
			return ps;
		};

		jdbcTemplate.update(creator);

		return employee;
	}
	public void delete(int id) {
		System.out.println("EmployeeDao : delete(-)");
		jdbcTemplate.update(Queries.DELETE.getQuery(), id);
	}
	
	

}
