package com.formation.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.TaskService;


@Named
@Controller
@RequestScoped
public class TaskController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Task task;
	
	private int eventId;
	private String eventStart;
	private String eventEnd;
	
	private int selectObjectifId;


	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ObjectifService objectifService;
	
	private List<Objectif> objectifs;


	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}	
	
	public int getSelectObjectifId() {
		return selectObjectifId;
	}

	public void setSelectObjectifId(int selectObjectifId) {
		this.selectObjectifId = selectObjectifId;
	}

	
	public String getEventStart() {
		return eventStart;
	}

	public void setEventStart(String eventStart) {
		this.eventStart = eventStart;
	}

	public String getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(String eventEnd) {
		this.eventEnd = eventEnd;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@PostConstruct
	public void init() {
		task = new Task();
	}
	

	public ObjectifService getObjectifService() {
		return objectifService;
	}

	public void setObjectifService(ObjectifService objectifService) {
		this.objectifService = objectifService;
	}
	
	public String createTask() {
		Objectif selectObjectif = new Objectif();
		
		if(objectifs.size() > 0){
			for(Objectif ob : objectifs){
				if(ob.getId() == selectObjectifId){
					selectObjectif = ob;
					break;
				}
			}
		}else{
			System.out.println("---------");
		}
		
		if(selectObjectif.fieldNotEmpty()){
			
			try {
				Objectif ob = this.objectifService.findById(selectObjectifId);
			} catch (ErrorExeption e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.task.setObjectifId(selectObjectifId);
			try {
				taskService.createTask(this.task);
			} catch (ErrorExeption e) {			
				System.out.println("**********************");
				System.out.println(e.getExeptionMessage());
			}
			this.task = new Task();
		}
		this.task = new Task();
		return "/home/home";
	}
	
	public String updateTask() {
		Task task = null;
		try {
			task = taskService.findById(eventId);
			task.setTitle(this.task.getTitle());
			task.setStart(this.task.getStart());
			task.setEnd(this.task.getEnd());
			task.setPlace(this.task.getPlace());
			task.setPriorityLevel(this.task.getPriorityLevel()); 
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
		}
		
		try {
			taskService.createTask(task);
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
		}
		return "/home/home";
	}
	
	
	public String deleteTask() {
		taskService.deleteTask(eventId);
		return "/home/home";
	}
	
	
	public String updateTaskDrag() {
		Task task = null;
		try {
			task = taskService.findById(eventId);
			task.setStart(eventStart);
			task.setEnd(eventEnd);
			task.setObjectifId(selectObjectifId);
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
		}
		
		try {
			taskService.createTask(task);
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
		}
		return "/home/home";
	}
	
	public List<Task> getTasks() throws ErrorExeption{
		List<Task> tasks = new ArrayList<Task>();
		
		SessionUtils session = SessionUtils.getInstance();
		User currentUser = (User) session.getAttribute("current_user");		
		System.out.println(currentUser.toString());
		try {
			tasks = taskService.findByObjectifId(currentUser.getId());
			return tasks;
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			tasks = new ArrayList<Task>();
			return tasks;
		}
	}
}
