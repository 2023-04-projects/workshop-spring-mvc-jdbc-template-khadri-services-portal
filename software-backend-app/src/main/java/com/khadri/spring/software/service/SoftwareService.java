package com.khadri.spring.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.software.dao.SoftwareDao;
import com.khadri.spring.software.form.SoftwareForm;

@Service
public class SoftwareService {
	private SoftwareDao softwareDao;

	@Autowired
	public SoftwareService(SoftwareDao softwareDao) {
		this.softwareDao = softwareDao;
	}

	public SoftwareForm save(SoftwareForm software) {
		softwareDao.save(software);
		return null;
	}
	//
//		public CustomerForm update(CustomerForm customer) {
//			return customer;
//			// TODO Auto-generated method stub
//			
//		}
	//
//		public void delete(int id) {
//			// TODO Auto-generated method stub
//			
//		}
	//
//		public CustomerForm findById(int id) {
//			// TODO Auto-generated method stub
//			return null;
//		}
	//
//		public List<CustomerForm> findByName(String name) {
//			// TODO Auto-generated method stub
//			return null;
//		}
	//
//		public List<CustomerForm> findByAddress(String address) {
//			// TODO Auto-generated method stub
//			return null;
//		}
	//
//		public List<CustomerForm> findByPhoneNumber(long phoneNumber) {
//			// TODO Auto-generated method stub
//			return null;
//		}

}
