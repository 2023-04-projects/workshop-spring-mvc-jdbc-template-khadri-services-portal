
package com.khadri.spring.author.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.author.dao.AuthorDao;
import com.khadri.spring.author.form.AuthorForm;

@Service
public class AuthorService {

	private AuthorDao authorDao;

	@Autowired
	public AuthorService(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public AuthorForm save(AuthorForm author) {
		return authorDao.save(author);
	}

	public AuthorForm update(AuthorForm author) {
		return authorDao.update(author);
	}

	public AuthorForm findById(int id) {
		return authorDao.findById(id);
	}

	public void delete(int id) {
		authorDao.delete(id);
	}

	public List<AuthorForm> findByName(String name) {
		return authorDao.findByName(name);
	}

	public List<AuthorForm> findBySkillsets(String skillsets) {
		return authorDao.findBySkillsets(skillsets);
	}

	public List<AuthorForm> findByYear(int year) {
		return authorDao.findByYear(year);
	}
}