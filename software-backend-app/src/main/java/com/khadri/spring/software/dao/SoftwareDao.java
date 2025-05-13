package com.khadri.spring.software.dao;

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

import com.khadri.spring.software.config.query.constants.SoftwareQueries;
import com.khadri.spring.software.form.SoftwareForm;

@Repository
public class SoftwareDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SoftwareDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SoftwareForm save(SoftwareForm software) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		PreparedStatementCreator creator = con -> {
			PreparedStatement ps = con.prepareStatement(SoftwareQueries.INSERT.getQuery(),
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, software.getName());
			ps.setString(2, software.getAddress());
			ps.setLong(3, software.getPhoneNumber());
			return ps;
		};

		jdbcTemplate.update(creator, keyHolder);

		software.setId(keyHolder.getKey().intValue());
		return software;
	}

	public SoftwareForm update(SoftwareForm softwareForm) {
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(SoftwareQueries.UPDATE.getQuery());
			ps.setString(1, softwareForm.getName());
			ps.setString(2, softwareForm.getAddress());
			ps.setLong(3, softwareForm.getPhoneNumber());
			ps.setInt(4, softwareForm.getId());
			return ps;
		});
		return softwareForm;
	}

	public SoftwareForm findById(int id) {
		System.out.println("SoftwareDao : findById(-)");
		return jdbcTemplate.queryForObject(SoftwareQueries.FIND_BY_ID.getQuery(),
				new BeanPropertyRowMapper<>(SoftwareForm.class), id);
	}

	public List<SoftwareForm> findByName(String name) {
		System.out.println("SoftwareDao : findByName(-)");
		return jdbcTemplate.query(SoftwareQueries.FIND_BY_NAME.getQuery(),
				new BeanPropertyRowMapper<>(SoftwareForm.class), name);
	}

	public List<SoftwareForm> findByAddress(String address) {
		System.out.println("SoftwareDao : findByAddress(-)");
		return jdbcTemplate.query(SoftwareQueries.FIND_BY_ADDRESS.getQuery(),
				new BeanPropertyRowMapper<>(SoftwareForm.class), address);
	}

	public List<SoftwareForm> findByPhoneNumber(long phoneNumber) {
		System.out.println("SoftwareDao : findByPhoneNumber(-)");
		return jdbcTemplate.query(SoftwareQueries.FIND_BY_PHONENUMBER.getQuery(),
				new BeanPropertyRowMapper<>(SoftwareForm.class), phoneNumber);
	}

	public void delete(int id) {
		System.out.println("SoftwareDao : delete(-)");
		jdbcTemplate.update(SoftwareQueries.DELETE.getQuery(), id);
	}

}
