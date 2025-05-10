package com.khadri.spring.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.employee.dao.EmployeeDao;
import com.khadri.spring.employee.form.EmployeeForm;
@Service
public class EmployeeService {
	
	private EmployeeDao dao;

	@Autowired
	public EmployeeService(EmployeeDao dao) {
		this.dao = dao;
	}

	public EmployeeForm save(EmployeeForm employee) {
		return dao.save(employee);
	}

	public EmployeeForm update(EmployeeForm employee) {
		return dao.update(employee);
	}


	public void delete(int id) {
		dao.delete(id);
	}

	public EmployeeForm findById(int id) {
		return dao.findById(id);
	}

	public List<EmployeeForm> findByName(String name) {
		return dao.findByName(name);
	}

	public List<EmployeeForm> findBySalary(double salary) {
		return dao.findBySalary(salary);
	}

	
}
