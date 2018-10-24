package com.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findByObjectifId(int id) {
		String sql = "SELECT task.* FROM task AS task WHERE objectif_id = ?";
		List<Task> tasks = new ArrayList<Task>();
		try {
			tasks = taskManager.createNativeQuery(sql).setParameter(1, id).getResultList();
		} catch (NoResultException e) {
		}
		return tasks;
	}
}
