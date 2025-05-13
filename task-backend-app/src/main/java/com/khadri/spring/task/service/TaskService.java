package com.khadri.spring.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.task.dao.TaskDAO;
import com.khadri.spring.task.form.TaskForm;

@Service
public class TaskService {

	private TaskDAO taskDAO;

	@Autowired
	public TaskService(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	public TaskForm save(TaskForm taskForm) {
		return taskDAO.save(taskForm);		
	}

	public TaskForm update(TaskForm taskForm) {
		return taskDAO.update(taskForm); 
	}

	public TaskForm findById(int id) {
		return taskDAO.findById(id);
	}

	public void delete(int id) {
		taskDAO.delete(id);
	}

	public List<TaskForm> findByPriority(String priority) {
		return taskDAO.findByPriority(priority);
				
	}

	public List<TaskForm> findByStatus(String status) {
		return taskDAO.findByStatus(status);
	}

	public List<TaskForm> findByCost(double cost) {
		return taskDAO.findByCost(cost);
	}
}
