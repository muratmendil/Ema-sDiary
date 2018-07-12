package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Task;


@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
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
