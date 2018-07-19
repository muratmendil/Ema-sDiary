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
<<<<<<< HEAD:src/main/java/com/formation/controller/MainController.java
	private User current_user;

=======
	
>>>>>>> task:src/main/java/com/formation/controller/HomeController.java
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
<<<<<<< HEAD:src/main/java/com/formation/controller/MainController.java
		this.current_user = new User();
		// this.objectifs = getObjectifs();
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

=======
	}

>>>>>>> task:src/main/java/com/formation/controller/HomeController.java
	public String goToProfil() {
		System.out.println("++" + user);
		return "/profil/profil";
	}

<<<<<<< HEAD:src/main/java/com/formation/controller/MainController.java
<<<<<<< HEAD
=======
	// public String logUser() {
	// User logUser = null;
	// logUser = userService.findByEmail(user.getEmail(), user.getPassword());
	// if (logUser != null) {
	// user = logUser;
	// return "home";
	// }
	// return null;
	// }
>>>>>>> profil

	
	public String getCurrentUserName() {
		return SessionUtils.getUserName();
	}

	public String logUser() {
		User logUser = userService.findByEmail(user.getEmail(), user.getPassword());
		if (logUser != null) {
			return valide(logUser);
		}
		return null;
	}

	String valide(User user) {
		boolean valid = userService.validate(user.getEmail(), user.getPassword());
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user.getName());
			session.setAttribute("userId", user.getId());
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}

	public String createUser() {
		User us = userService.createUser(this.user);
		return "index";
	}

=======
	public String getCurrentUserName(){
		return SessionUtils.getUserName();
	}
	
>>>>>>> task:src/main/java/com/formation/controller/HomeController.java
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
<<<<<<< HEAD
	
	public List<Objectif> getObjectifs(){
=======

	public List<Objectif> getObjectifs() {
>>>>>>> profil
		int id = SessionUtils.getUserId();
		List<Objectif> objectifs = objectifService.getAll(id);

		if (objectifs != null && objectifs.size() > 0) {

			return objectifs;
<<<<<<< HEAD
=======

>>>>>>> profil
		}
		return null;
	}
<<<<<<< HEAD:src/main/java/com/formation/controller/MainController.java

	/*
	 * public List<Objectif> getObjectifs(){ int id = SessionUtils.getUserId();
	 * return objectifService.getAll(id); }
	 */
=======
>>>>>>> task:src/main/java/com/formation/controller/HomeController.java
}
