package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.TaskDao;
import com.formation.model.Task;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskDao taskDao;

	@Override
	public Task createTask(Task task) {
		return taskDao.createTask(task);
	}

	@Override
	public Task findById(int id) {
		return taskDao.findById(id);
	}

	@Override
	public void deleteTask(int id) {
		taskDao.deleteTask(id);
	}
}
