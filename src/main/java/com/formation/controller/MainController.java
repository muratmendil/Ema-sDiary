package com.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.dao.UserDaoImpl;
import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.SessionUtils;
import com.formation.service.UserService;

@Named
@Controller
@RequestScoped
public class MainController {

	private User user;
	private Objectif objectif;
	private Task task;

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

	public String index() {
		return "index";
	}

	public String goToHome() {
		return "home";
	}

<<<<<<< HEAD
=======
	public String goToProfil() {
		System.out.println("++" + user);
		return "profil";
	}

>>>>>>> 654a39b349f75817112fefe1b01c0b16fea70ebc
	public String goToSignUp() {
		return "signUp";
	}

	public String logUser() {
		User logUser = null;
		logUser = userService.findByEmail(user.getEmail(), user.getPassword());
		if (logUser != null) {
			user = logUser;
			return "home";
		}
		return null;
	}

<<<<<<< HEAD
=======
	public String amqUser() {
		User logUser = null;
		logUser = userService.findByEmail(user.getEmail(), user.getPassword());
		if (logUser != null) {
			user = logUser;
			return valide(user.getEmail(), user.getPassword());
		}
		return null;
	}

	String valide(String email, String password) {

		boolean valid = userService.validate(email, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", email);
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}

>>>>>>> 654a39b349f75817112fefe1b01c0b16fea70ebc
	public String createUser() {
		User us = userService.createUser(this.user);
		return "index";
	}

<<<<<<< HEAD
	public String createObjectif() {
		System.out.println("Obj");
		System.out.println(this.objectif);
		List<Objectif> objectifs = new ArrayList<Objectif>();
		objectifs.add(this.objectif);
		User user = userService.findById(1);
		if (user != null) {
			user.setObjectifs(objectifs);
			this.objectif.setUser(user);
			userService.createUser(user);
			this.objectif.reset();
		}

		return "home";
	}

	public String createTask() {

		return "home";
	}

=======
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

>>>>>>> 654a39b349f75817112fefe1b01c0b16fea70ebc
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

}
