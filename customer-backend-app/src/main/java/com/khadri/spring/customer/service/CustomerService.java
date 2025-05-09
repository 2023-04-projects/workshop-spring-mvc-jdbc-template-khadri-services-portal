package com.khadri.spring.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.customer.dao.CustomerDao;
import com.khadri.spring.customer.form.CustomerForm;

@Service
public class CustomerService {

    private CustomerDao custDao;

    @Autowired
    public CustomerService(CustomerDao custDao) {
        this.custDao = custDao;
    }

	public CustomerForm save(CustomerForm customerForm) {
		return custDao.save(customerForm);
	}
	public CustomerForm update(CustomerForm customerForm) {
		return custDao.update(customerForm);
	}

	public CustomerForm findById(int id) {
		return custDao.findById(id);
	}
	public void delete(int id) {
		custDao.delete(id);
	}
	public List<CustomerForm> findByName(String name) {
		return custDao.findByName(name);
	}

	public List<CustomerForm> findByAddress(String address) {
		return custDao.findByAddress(address);
	}

	public List<CustomerForm> findByPhoneNumber(long phoneNumber) {
		return custDao.findByPhoneNumber(phoneNumber);
	}
}
