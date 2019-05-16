package com.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.TaskService;
import com.formation.service.UserService;


@RestController
public class TaskApi {


	@Autowired TaskService taskService;
	
	@Autowired UserService userService;

	@GetMapping("test")
	public String todo() {
		return "ema apps";
	}

	
	@GetMapping("user/{id}/objectifs/tasks")
	public ResponseEntity<List<Task>> getObjectifsTask(@PathVariable(value = "id") int id){
		List<Task> tasks = new ArrayList<>();

		try {
			User user =  userService.findById(id);
			try {
				tasks =  taskService.findByUserId(id);

			    return ResponseEntity.ok(tasks);

			} catch (ErrorExeption e) {
				throw e;
			}
		} catch (ErrorExeption e1) {
			return ResponseEntity.ok(tasks);

		}
	 }
	
	
	@GetMapping("user/{userId}/objectif/{objectifId}/tasks")
	public ResponseEntity<List<Task>> getObjectifTask(@PathVariable(value = "id") int id, @PathVariable(value = "objectifId") int objectifId){
		List<Task> tasks = new ArrayList<>();

		try {
			User user =  userService.findById(id);
			try {
				tasks =  taskService.findByUserId(objectifId);

			    return ResponseEntity.ok(tasks);

			} catch (ErrorExeption e) {
				throw e;
			}
		} catch (ErrorExeption e1) {
		    return ResponseEntity.ok(tasks);
		}
	 }
	
	 @PostMapping("/newTask")
	 public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
		try {
			Task newTask = taskService.createTask(task);
			return ResponseEntity.ok(newTask);
		} catch (ErrorExeption e) {
			return ResponseEntity.ok(new Task());
		} 
	 }
	
	
	 @DeleteMapping("/deleteTask/{id}")
	 public ResponseEntity<Boolean> deleteTask (@PathVariable(value = "id") int id){
		 	taskService.deleteTask(id);
			return ResponseEntity.ok(true);
	 }
	
	 
	 @PutMapping("/updateTask")
	 public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task){
		 try {
				Task newTask =  taskService.createTask(task);
				return ResponseEntity.ok(newTask);
			} catch (ErrorExeption e) {
				return ResponseEntity.ok(new Task());
			} 
	 }
}
