package com.khadri.spring.task.dao;

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

import com.khadri.spring.task.config.query.constants.TaskQueries;
import com.khadri.spring.task.form.TaskForm;

@Repository
public class TaskDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TaskDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public TaskForm save(TaskForm task) {
		System.out.println("TaskDAO : save");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(TaskQueries.INSERT.getQuery(),
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, task.getPriority());
			ps.setString(2, task.getStatus());
			ps.setDouble(3, task.getCost());
			return ps;
		};

		jdbcTemplate.update(creator, keyHolder);

		task.setId(keyHolder.getKey().intValue());
		return task;
	}

	public TaskForm update(TaskForm taskForm) {
		System.out.println("TaskDAO : update");
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(TaskQueries.UPDATE.getQuery());
			ps.setString(1, taskForm.getPriority());
			ps.setString(2, taskForm.getStatus());
			ps.setDouble(3, taskForm.getCost());
			ps.setInt(4, taskForm.getId());
			return ps;
		});
		return taskForm;
	}

	public TaskForm findById(int id) {
		System.out.println("TaskDAO : findById(-)");
		return jdbcTemplate.queryForObject(TaskQueries.FIND_BY_ID.getQuery(),
				new BeanPropertyRowMapper<>(TaskForm.class), id);
	}

	public List<TaskForm> findByPriority(String priority) {
		System.out.println("TaskDAO : findByPriority(-)");
		return jdbcTemplate.query(TaskQueries.FIND_BY_PRIORITY.getQuery(),
				new BeanPropertyRowMapper<>(TaskForm.class), priority);
	}

	public List<TaskForm> findByStatus(String status) {
		System.out.println("TaskDAO : findByStatus(-)");
		return jdbcTemplate.query(TaskQueries.FIND_BY_STATUS.getQuery(),
				new BeanPropertyRowMapper<>(TaskForm.class), status);
	}

	public List<TaskForm> findByCost(double cost) {
		System.out.println("TaskDAO : findByCost(-)");
		return jdbcTemplate.query(TaskQueries.FIND_BY_COST.getQuery(),
				new BeanPropertyRowMapper<>(TaskForm.class), cost);
	}

	public void delete(int id) {
		System.out.println("TaskDAO : delete(-)");
		jdbcTemplate.update(TaskQueries.DELETE.getQuery(), id);
	}

}
