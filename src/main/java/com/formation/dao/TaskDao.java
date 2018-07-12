package com.formation.dao;

import com.formation.model.Task;
import com.formation.model.User;

public interface TaskDao {
	
	Task createTask(Task task);
	Task findById(int id);

}
