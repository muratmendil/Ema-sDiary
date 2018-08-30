package com.formation.service;

import java.util.List;

import com.formation.model.Task;

public interface TaskService {

	 Task createTask(Task task);
	 Task findById(int id);
	 void deleteTask(int id);

}
