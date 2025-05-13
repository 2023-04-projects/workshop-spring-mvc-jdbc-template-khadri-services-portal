package com.khadri.spring.software.service;

import java.util.List;

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

	public SoftwareForm save(SoftwareForm softwareForm) {
		return softwareDao.save(softwareForm);
	}

	public SoftwareForm update(SoftwareForm softwareForm) {
		return softwareDao.update(softwareForm);
	}

	public SoftwareForm findById(int id) {
		return softwareDao.findById(id);
	}

	public void delete(int id) {
		softwareDao.delete(id);
	}

	public List<SoftwareForm> findByName(String name) {
		return softwareDao.findByName(name);
	}

	public List<SoftwareForm> findByAddress(String address) {
		return softwareDao.findByAddress(address);
	}

	public List<SoftwareForm> findByPhoneNumber(long phoneNumber) {
		return softwareDao.findByPhoneNumber(phoneNumber);
	}
}
