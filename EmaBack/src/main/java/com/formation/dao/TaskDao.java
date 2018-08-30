package com.formation.dao;

import com.formation.model.Task;

public interface TaskDao {

 Task createTask(Task task);
 Task findById(int id);
 void deleteTask(int id);
	
}
