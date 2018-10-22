package com.formation.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import com.formation.model.User;

@Named
@Controller
@RequestScoped
public class ProfilController {
	
	
	User currentUser;
	
	@PostConstruct
	public void init() {
		currentUser = new User();
		
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getCurrentUserFirstName(){
		SessionUtils sesion = SessionUtils.getInstance();
		User currentUser = sesion.getCurrentUser();
		return currentUser.getFirstName();
	}
	
	public String getCurrentUserLastName(){
		SessionUtils sesion = SessionUtils.getInstance();
		User currentUser = sesion.getCurrentUser();
		return currentUser.getLastName();
	}
	
	public String getCurrentUserEmail(){
		SessionUtils sesion = SessionUtils.getInstance();
		User currentUser = sesion.getCurrentUser();
		return currentUser.getEmail();
	}
	
	public String getCurrentUserBirthDate(){
		SessionUtils sesion = SessionUtils.getInstance();
		User currentUser = sesion.getCurrentUser();
		return currentUser.getBirthDate();
	}
}
