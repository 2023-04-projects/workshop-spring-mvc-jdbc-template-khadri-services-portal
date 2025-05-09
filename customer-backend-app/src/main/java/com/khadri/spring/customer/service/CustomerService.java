package com.khadri.spring.customer.service;

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

	public CustomerForm save(CustomerForm customer) {
		custDao.save(customer);
		return null;
	}
//
//	public CustomerForm update(CustomerForm customer) {
//		return customer;
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public CustomerForm findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CustomerForm> findByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CustomerForm> findByAddress(String address) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CustomerForm> findByPhoneNumber(long phoneNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//    
}
