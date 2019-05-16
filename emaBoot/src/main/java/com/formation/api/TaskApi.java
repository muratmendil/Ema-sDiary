package com.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.TaskService;
import com.formation.service.UserService;

@RestController
public class TaskApi {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private TaskService taskService;
	

	@GetMapping("test")
	public String todo() {
		return "iuiii";
	}
	
	@GetMapping("user/{id}/objectifs/tasks")
	public List<Task> getObjectifsTask(@PathVariable(value = "id") int id){
		List<Task> tasks = new ArrayList<>();

		try {
			User user =  userService.findById(id);
			try {
				tasks =  taskService.findByUserId(id);

			    return tasks;

			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return tasks;
			}
		} catch (ErrorExeption e1) {
			return tasks;
		}
	 }
	
	
	@GetMapping("user/{userId}/objectif/{objectifId}/tasks")
	public List<Task> getObjectifTask(@PathVariable(value = "id") int id, @PathVariable(value = "objectifId") int objectifId){
		List<Task> tasks = new ArrayList<>();

		try {
			User user =  userService.findById(id);
			try {
				tasks =  taskService.findByObjectifId(objectifId);

			    return tasks;

			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return tasks;
			}
		} catch (ErrorExeption e1) {
			return tasks;
		}
	 }
	
	 @PostMapping("/newTask")
	 public Task createTask(@Valid @RequestBody Task task){
		try {
			return taskService.createTask(task);
		} catch (ErrorExeption e) {
			return new Task();
		} 
	 }
	
	
	 @DeleteMapping("/deleteTask/{id}")
	 public boolean deleteTask (@PathVariable(value = "id") int id){
			taskService.deleteTask(id);
			return true;
	 }
	
	 
	 @PutMapping("/updateTask")
	 public Task updateTask(@Valid @RequestBody Task task){
		 try {
				Task newTask =  taskService.createTask(task);
				return newTask;
			} catch (ErrorExeption e) {
				return new Task();
			} 
	 }
}
