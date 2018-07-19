package com.formation.controller;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.formation.model.User;

import com.formation.service.SessionUtils;
import com.formation.service.UserService;

@Named
@Controller
@RequestScoped
public class LoginController {

	private User user;
	
	@Autowired
	private UserService userService;

	
	public User getUser() {
		return user;
	}


	public UserService getUserService() {
		return userService;
	}

	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@PostConstruct
	public void init() {
		user = new User();
	}

	public String goToSignUp() {
		return "/signUp/signUp";
	}


	public String getCurrentUserName(){
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
			session.setAttribute("username",user.getName() );
			session.setAttribute("userId", user.getId());
			return "/home/home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}
}
