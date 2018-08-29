package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.formation.model.Task;

public class TaskDaoImpl implements TaskDao {
	
private static final Logger logger = LoggerFactory.getLogger(ObjectifDaoImpl.class);
	
	@PersistenceContext
	private EntityManager taskManager;

	@Override
	public Task createTask(Task task) {
		return taskManager.merge(task);
	}

	@Override
	public Task findById(int id) {
		return taskManager.find(Task.class, id);
	}
}
