package com.formation.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;

import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.SessionUtils;
import com.formation.service.TaskService;


@Named
@Controller
@RequestScoped
public class TaskController implements Serializable {

	/**
	 * 
	 */
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
		for(Objectif ob : objectifs){
			if(ob.getId() == selectObjectifId){
				selectObjectif = ob;
				break;
			}
		}
		
		if(selectObjectif != null){
			this.task.setObjectif(selectObjectif);
		}
		taskService.createTask(this.task);
		this.task = new Task();
		return "/home/home";
	}
	
	public String updateTask() {
		Task task = taskService.findById(eventId);
		task.setName(this.task.getName());
		task.setStartDate(this.task.getStartDate());
		task.setEndDate(this.task.getEndDate());
		task.setPlace(this.task.getPlace());
		task.setPriorityLevel(this.task.getPriorityLevel()); 
		taskService.createTask(task);
		return "/home/home";
	}
	
	
	public String deleteTask() {
		taskService.deleteTask(eventId);
		return "/home/home";
	}
	
	
	public String updateTaskDrag() {
		Task task = taskService.findById(eventId);
		task.setStartDate(eventStart);
		task.setEndDate(eventEnd);
		taskService.createTask(task);
		return "/home/home";
	}
	
	public List<Objectif> getObjectifs(){
		SessionUtils session = SessionUtils.getInstance();
		User currentUser = (User) session.getAttribute("current_user");		
		if(currentUser == null){
			System.out.println("session4 null");
		}
		List<Objectif> objectifs = objectifService.getAll(currentUser.getId());
		if(objectifs != null && objectifs.size() > 0){
			this.objectifs = objectifs;
			return objectifs;
		}
		return null;
	}
	
	public List<Task> getTasks(){
		List<Task> tasks = new ArrayList<Task>();
		
		SessionUtils session = SessionUtils.getInstance();
		User currentUser = (User) session.getAttribute("current_user");		
		
		List<Objectif> objectifs = objectifService.getAll(currentUser.getId());
		if(objectifs != null && objectifs.size() > 0){
				for(Objectif ob : objectifs){
					if(ob.getTasks().size() > 0){
						tasks.addAll(ob.getTasks());
					}
				}
		}
		return tasks;
	}
}