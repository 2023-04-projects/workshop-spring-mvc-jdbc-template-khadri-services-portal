package com.khadri.spring.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.customer.dao.CustomerJdbcTemplateDao;
import com.khadri.spring.customer.form.CustomerForm;

@Service
public class CustomerService {

    private CustomerJdbcTemplateDao jdbcTemplateDao;

    @Autowired
    public CustomerService(CustomerJdbcTemplateDao jdbcTemplateDao) {
        this.jdbcTemplateDao = jdbcTemplateDao;
    }

    public CustomerForm save(CustomerForm customer) {
        return jdbcTemplateDao.save(customer);
    }

    public CustomerForm update(CustomerForm customer) {
        return jdbcTemplateDao.update(customer);
    }

    public CustomerForm partialUpdate(int id, Map<String, Object> updates) {
        return jdbcTemplateDao.partialUpdate(id, updates);
    }

    public void delete(int id) {
        jdbcTemplateDao.delete(id);
    }

    public CustomerForm findById(int id) {
        return jdbcTemplateDao.findById(id);
    }

    public List<CustomerForm> findByName(String name) {
        return jdbcTemplateDao.findByName(name);
    }
}
