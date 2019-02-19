package com.formation.dao;

import java.util.List;

import com.formation.model.Task;

public interface TaskDao {

 Task createTask(Task task);
 Task findById(int id);
 List<Task> findByObjectifId(int id);
 void deleteTask(int id);
 List<Task> findByUserId(int id);

}
