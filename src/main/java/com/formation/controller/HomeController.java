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
	private Objectif objectif;
	private Task task;
	private Objectif selectObjectif;

	public List<Objectif> objectifs = new ArrayList<>();

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
	}


	public String sayHello() {
		return "hello";
	}

	public String index() {
		return "index";
	}

	public String goToHome() {
		return "home";
	}

	public String goToProfil() {
		System.out.println("++" + user);
		return "/profil/profil";
	}
<<<<<<< HEAD
	
	public String getCurrentUserName() {
		return SessionUtils.getUserName();
=======

	public String getCurrentUserFirstName(){
		return SessionUtils.getUserFirstName();
>>>>>>> task
	}

	public String createObjectif() {
		List<Objectif> objectifs = new ArrayList<Objectif>();
		objectifs.add(this.objectif);
		User user = userService.findById(1);
		if (user != null) {
			user.setObjectifs(objectifs);
			this.objectif.setUser(user);
			userService.createUser(user);
			this.objectif.reset();
		}

		return "/home/home";
	}

	
	public String createTask() {
		return "/home/home";
	}

	public List<Objectif> getObjectifs(){
		int id = SessionUtils.getUserId();
		List<Objectif> objectifs = objectifService.getAll(id);

		if (objectifs != null && objectifs.size() > 0) {

			return objectifs;
		}
		return null;
	}

}
