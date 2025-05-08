package com.khadri.spring.student.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.student.dao.StudentDAO;
import com.khadri.spring.student.dao.StudentJdbcTemplateDao;
import com.khadri.spring.student.form.StudentForm;

@Service
public class StudentService {

	// core jdbc dao not used instead used jdbc template from spring
	private StudentDAO dao;

	// used for dao operations
	private StudentJdbcTemplateDao jdbcTemplateDao;

	@Autowired
	public StudentService(StudentDAO dao, StudentJdbcTemplateDao jdbcTemplateDao) {
		this.dao = dao;
		this.jdbcTemplateDao = jdbcTemplateDao;
	}

	public StudentForm save(StudentForm student) {
		return jdbcTemplateDao.save(student);
	}

	public StudentForm update(StudentForm student) {
		return jdbcTemplateDao.update(student);
	}

	public StudentForm update(int id, Map<String, Object> updates) {
		return jdbcTemplateDao.partialUpdate(id, updates);
	}

	public void delete(int id) {
		jdbcTemplateDao.delete(id);
	}

	public StudentForm findById(int id) {
		return jdbcTemplateDao.findById(id);
	}

	public List<StudentForm> findByName(String name) {
		return jdbcTemplateDao.findByName(name);
	}

	public List<StudentForm> findByCourse(String course) {
		return jdbcTemplateDao.findByCourse(course);
	}

	public List<StudentForm> findByMarks(int marks) {
		return jdbcTemplateDao.findByMarks(marks);
	}

}
