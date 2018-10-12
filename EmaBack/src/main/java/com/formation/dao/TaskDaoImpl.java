package com.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Task;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {
	
	
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

	@Override
	public void deleteTask(int id) {
		String sql = "DELETE task.* FROM task AS task WHERE task_id = ?";
		Query query = taskManager.createNativeQuery(sql, Task.class);
		query.setParameter(1, id);
		int res = query.executeUpdate();
		System.out.println("++++++++++++");
		System.out.println(res);
	}
}
