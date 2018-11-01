package com.formation.service;

import java.util.List;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Task;

public interface TaskService {

	 Task createTask(Task task) throws ErrorExeption;
	 Task findById(int id) throws ErrorExeption;
	 void deleteTask(int id);
	 List<Task> findByObjectifId(int id) throws ErrorExeption;
	 List<Task> findByUserId(int id) throws ErrorExeption;
}
