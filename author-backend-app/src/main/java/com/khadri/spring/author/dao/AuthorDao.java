package com.khadri.spring.author.dao;

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

import com.khadri.spring.author.config.query.constants.AuthorQueries;
import com.khadri.spring.author.form.AuthorForm;

@Repository
public class AuthorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AuthorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public AuthorForm save(AuthorForm author) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		System.out.println("JdbcTemplate : save(-)");

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(AuthorQueries.INSERT.getQuery(),
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, author.getName());
			ps.setString(2, author.getSkillsets());
			ps.setInt(3, author.getYear());
			return ps;
		};

		int result = jdbcTemplate.update(creator, keyHolder);

		author.setId(keyHolder.getKey().intValue());

		return author;
	}

	public AuthorForm update(AuthorForm author) {
		System.out.println("JdbcTemplate : update(-)");

		jdbcTemplate.update(con -> {
			PreparedStatement ps = con.prepareStatement(AuthorQueries.UPDATE.getQuery());
			ps.setString(1, author.getName());
			ps.setString(2, author.getSkillsets());
			ps.setInt(3, author.getYear());
			ps.setInt(4, author.getId());
			return ps;
		});
		return author;
	}

	public AuthorForm findById(int id) {
		System.out.println("JdbcTemplate : findById(-)");
		return jdbcTemplate.queryForObject(AuthorQueries.FIND_BY_ID.getQuery(),
				new BeanPropertyRowMapper<>(AuthorForm.class), id);
	}

	public List<AuthorForm> findByName(String name) {
		System.out.println("JdbcTemplate : findByName(-)");
		return jdbcTemplate.query(AuthorQueries.FIND_BY_NAME.getQuery(), new BeanPropertyRowMapper<>(AuthorForm.class),
				name);
	}

	public List<AuthorForm> findBySkillsets(String skillsets) {
		System.out.println("JdbcTemplate : findBySkillsets(-)");
		return jdbcTemplate.query(AuthorQueries.FIND_BY_SKILLSETS.getQuery(),
				new BeanPropertyRowMapper<>(AuthorForm.class), skillsets);
	}

	public List<AuthorForm> findByYear(int year) {
		System.out.println("JdbcTemplate : findByYear(-)");
		return jdbcTemplate.query(AuthorQueries.FIND_BY_YEAR.getQuery(), new BeanPropertyRowMapper<>(AuthorForm.class),
				year);
	}

	public void delete(int id) {
		System.out.println("JdbcTemplate : delete(-)");
		jdbcTemplate.update(AuthorQueries.DELETE.getQuery(), id);
	}

}
