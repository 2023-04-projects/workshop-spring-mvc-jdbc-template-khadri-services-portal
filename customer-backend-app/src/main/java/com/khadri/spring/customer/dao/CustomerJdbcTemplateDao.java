package com.khadri.spring.customer.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.khadri.spring.customer.config.query.constants.CustomerQueries;
import com.khadri.spring.customer.form.CustomerForm;

@Repository
public class CustomerJdbcTemplateDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public CustomerForm findById(int id) {
//        return jdbcTemplate.queryForObject(CustomerQueries.FIND_BY_ID.getQuery(),
//            new BeanPropertyRowMapper<>(CustomerForm.class), id);
//    }
//
//    public List<CustomerForm> findByName(String name) {
//        return jdbcTemplate.query(CustomerQueries.FIND_BY_NAME.getQuery(),
//            new BeanPropertyRowMapper<>(CustomerForm.class), "%" + name + "%");
//    }

    public CustomerForm save(CustomerForm customer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
            		CustomerQueries.INSERT.getQuery(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setLong(3, customer.getPhoneNumber());
            return ps;
        }, keyHolder);

        customer.setId(keyHolder.getKey().intValue());
        return customer;
    }

//    public CustomerForm update(CustomerForm customer) {
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(CustomerQueries.UPDATE.getQuery());
//            ps.setString(1, customer.getName());
//            ps.setString(2, customer.getAddress());
//            ps.setLong(3, customer.getPhoneNumber());
//            ps.setInt(4, customer.getId());
//            return ps;
//        });
//        return customer;
//    }
//
//    public CustomerForm partialUpdate(int id, Map<String, Object> updates) {
//        StringBuilder sql = new StringBuilder("UPDATE customers SET ");
//        List<Object> values = new ArrayList<>();
//
//        updates.forEach((key, value) -> {
//            sql.append(key).append("=?, ");
//            values.add(value);
//        });
//
//        sql.setLength(sql.length() - 2); // remove trailing comma
//        sql.append(" WHERE id=?");
//        values.add(id);
//
//        jdbcTemplate.update(sql.toString(), values.toArray());
//
//        return findById(id);
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update(CustomerQueries.DELETE.getQuery(), id);
//    }
}
