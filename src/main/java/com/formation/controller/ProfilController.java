package com.formation.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import com.formation.model.User;
import com.formation.service.SessionUtils;

@Named
@Controller
@RequestScoped
public class ProfilController {
	
	
	User currentUser;
	
	@PostConstruct
	public void init() {
		currentUser = new User();
		
	}
	
	public String getCurrentUserFirstName(){
		return SessionUtils.getUserFirstName();
	}
	
	public String getCurrentUserLastName(){
		return SessionUtils.getUserLastName();
	}
	
	public String getCurrentUserEmail(){
		return SessionUtils.getUserEmail();
	}
	
	public String getCurrentUserBirthDate(){
		return SessionUtils.getUserBirthDate();
	}
}
