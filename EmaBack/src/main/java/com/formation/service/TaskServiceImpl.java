package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.TaskDao;
import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.Task;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public Task createTask(Task task) throws ErrorExeption{
		if(task.fieldNotEmpty()){
			return taskDao.createTask(task);
		}else{
			throw new ErrorExeption("Champs vide", "Un ou plusieurs champs sont vide");	
		}
	}

	@Override
	public Task findById(int id) throws ErrorExeption {
		Task task = taskDao.findById(id);
		if(task == null){
			throw new ErrorExeption("Null value", "Cette tache n'existe pas");
		}else{
			return task;
		}
	}

	@Override
	public void deleteTask(int id) {
		taskDao.deleteTask(id);	
	}

	@Override
	public List<Task> findByObjectifId(int id) throws ErrorExeption{
		List<Task> tasks = taskDao.findByObjectifId(id);
		if(tasks.size() == 0){
			throw new ErrorExeption("Aucune tache", "Cette objectif n'a aucune tache");
		}else{
			return tasks;
		}
	}

	@Override
	public List<Task> findByUserId(int id) throws ErrorExeption {
		List<Task> tasks = taskDao.findByUserId(id);
		if(tasks.size() == 0){
			throw new ErrorExeption("Aucune tache", "Cette utilisateur n'a aucune tache");
		}else{
			return tasks;
		}
	}
}
