package com.formation.service;

import com.formation.model.Task;

public interface TaskService {

	 Task createTask(Task task);
	 Task findById(int id);
}
