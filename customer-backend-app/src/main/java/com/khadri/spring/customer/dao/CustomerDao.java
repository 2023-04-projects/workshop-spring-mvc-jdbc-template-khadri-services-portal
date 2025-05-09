package com.khadri.spring.customer.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.khadri.spring.customer.config.query.constants.CustomerQueries;
import com.khadri.spring.customer.form.CustomerForm;

@Repository
public class CustomerDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public CustomerForm save(CustomerForm customer) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(CustomerQueries.INSERT.getQuery(),
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setLong(3, customer.getPhoneNumber());
			return ps;
		}, keyHolder);

		customer.setId(keyHolder.getKey().intValue());
		return customer;
	}

    public CustomerForm update(CustomerForm customerForm) {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(CustomerQueries.UPDATE.getQuery());
            ps.setString(1, customerForm.getName());
            ps.setString(2, customerForm.getAddress());
            ps.setLong(3, customerForm.getPhoneNumber());
            ps.setInt(4, customerForm.getId());
            return ps;
        });
        return customerForm;
    }
    public CustomerForm findById(int id) {
		System.out.println("CustomerDao : findById(-)");
		return jdbcTemplate.queryForObject(CustomerQueries.FIND_BY_ID.getQuery(),
				new BeanPropertyRowMapper<>(CustomerForm.class), id);
	}

    public List<CustomerForm> findByName(String name) {
		System.out.println("CustomerDao : findByName(-)");
		return jdbcTemplate.query(CustomerQueries.FIND_BY_NAME.getQuery(), new BeanPropertyRowMapper<>(CustomerForm.class),
				name);
	}

	public List<CustomerForm> findByAddress(String address) {
		System.out.println("CustomerDao : findByAddress(-)");
		return jdbcTemplate.query(CustomerQueries.FIND_BY_ADDRESS.getQuery(), new BeanPropertyRowMapper<>(CustomerForm.class),
				address);
	}

	public List<CustomerForm> findByPhoneNumber(int phoneNumber) {
		System.out.println("CustomerDao : findByPhoneNumber(-)");
		return jdbcTemplate.query(CustomerQueries.FIND_BY_PHONENUMBER.getQuery(), new BeanPropertyRowMapper<>(CustomerForm.class),
				phoneNumber);
	}
    public void delete(int id) {
		System.out.println("CustomerDao : delete(-)");
		jdbcTemplate.update(CustomerQueries.DELETE.getQuery(), id);
	}

}
