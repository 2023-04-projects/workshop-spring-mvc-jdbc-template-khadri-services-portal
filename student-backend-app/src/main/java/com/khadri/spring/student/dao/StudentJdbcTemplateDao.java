package com.khadri.spring.student.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.khadri.spring.student.config.query.constants.Queries;
import com.khadri.spring.student.form.StudentForm;

@Repository
public class StudentJdbcTemplateDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentJdbcTemplateDao(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public StudentForm findById(int id) {
		System.out.println("StudentJdbcTemplateDao : findById(-)");
		return jdbcTemplate.queryForObject(Queries.FIND_BY_ID.getQuery(),
				new BeanPropertyRowMapper<>(StudentForm.class), id);
	}

	public List<StudentForm> findByName(String name) {
		System.out.println("StudentJdbcTemplateDao : findByName(-)");
		return jdbcTemplate.query(Queries.FIND_BY_NAME.getQuery(), new BeanPropertyRowMapper<>(StudentForm.class),
				name);
	}

	public List<StudentForm> findByCourse(String course) {
		System.out.println("StudentJdbcTemplateDao : findByCourse(-)");
		return jdbcTemplate.query(Queries.FIND_BY_COURSE.getQuery(), new BeanPropertyRowMapper<>(StudentForm.class),
				course);
	}

	public List<StudentForm> findByMarks(int marks) {
		System.out.println("StudentJdbcTemplateDao : findByMarks(-)");
		return jdbcTemplate.query(Queries.FIND_BY_MARKS.getQuery(), new BeanPropertyRowMapper<>(StudentForm.class),
				marks);
	}

	public StudentForm save(StudentForm student) {
		System.out.println("StudentJdbcTemplateDao : save(-)");

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(Queries.INSERT.getQuery(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setInt(3, student.getMarks());
			return ps;
		};

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int result = jdbcTemplate.update(creator, keyHolder);

		if (result == 1) {
			student.setId(keyHolder.getKey().intValue());
		}

		return student;
	}

	public StudentForm update(StudentForm student) {
		System.out.println("StudentJdbcTemplateDao : update(-)");

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(Queries.UPDATE.getQuery());
			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setInt(3, student.getMarks());
			ps.setInt(4, student.getId());
			return ps;
		};

		jdbcTemplate.update(creator);

		return student;
	}

	public StudentForm partialUpdate(int id, Map<String, Object> updates) {
		System.out.println("StudentJdbcTemplateDao : partialUpdate(-)");
		
		StudentForm returnStudentForm = new StudentForm();
		StringBuilder builderSql = new StringBuilder("UPDATE students SET ");

		List<Object> values = new ArrayList<>();

		updates.keySet().stream().forEach(eachkey -> {
			builderSql.append(eachkey).append("=?, ");
			values.add(updates.get(eachkey));
		});

		builderSql.setLength(builderSql.length() - 2);
		builderSql.append(" WHERE id=?");
		values.add(id);

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(builderSql.toString());

			for (int i = 0; i < values.size(); i++) {
				ps.setObject(i + 1, values.get(i));
			}

			return ps;

		};

		int result = jdbcTemplate.update(creator);

		if (result == 1) {
			returnStudentForm = findById(id);
		}

		return returnStudentForm;
	}

	public void delete(int id) {
		System.out.println("StudentJdbcTemplateDao : delete(-)");
		jdbcTemplate.update(Queries.DELETE.getQuery(), id);
	}

}
