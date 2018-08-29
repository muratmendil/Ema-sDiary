package com.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.SessionUtils;
import com.formation.service.UserService;

@Named
@Controller
@RequestScoped
public class HomeController {

	private User user;
	public Objectif getSelectObjectif() {
		return selectObjectif;
	}

	public void setSelectObjectif(Objectif selectObjectif) {
		this.selectObjectif = selectObjectif;
	}


	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}

	private Objectif objectif;
	private Task task;
	
	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}

	private Objectif selectObjectif;
	
	public List<Objectif> objectifs = new ArrayList<Objectif>();

	@Autowired
	private UserService userService;

	@Autowired
	private ObjectifService objectifService;

	public User getUser() {
		return user;
	}


	public UserService getUserService() {
		return userService;
	}

	public ObjectifService getObjectifService() {
		return objectifService;
	}

	public void setObjectifService(ObjectifService objectifService) {
		this.objectifService = objectifService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	@PostConstruct
	public void init() {
		objectif = new Objectif();
		user = new User();
		task = new Task();
	}

	public String goToProfil() {
		System.out.println("**************************");
		return "/profil/profil?faces-redirect=true";
	}
	
	public String createObjectif() {
		SessionUtils session = SessionUtils.getInstance();
		User currentUser = (User) session.getAttribute("current_user");
		objectifService.createObjectif(currentUser.getId(), this.objectif);
		return "/home/home";
	}

	public String createTask() {
		
		return null;
	}
	
	public List<Objectif> getObjectifs(){
		SessionUtils session = SessionUtils.getInstance();
		User currentUser = (User) session.getAttribute("current_user");		
		if(currentUser == null){
			System.out.println("session4 null");
		}
		List<Objectif> objectifs = objectifService.getAll(currentUser.getId());
		if(objectifs != null && objectifs.size() > 0){
			
			return objectifs;
		}
		return null;
	}
}
