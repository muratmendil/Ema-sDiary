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
	
	FacesContext context;
	
	
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
		context = FacesContext.getCurrentInstance();
	}

	public String goToSignUp() {
		return "/signUp/signUp?faces-redirect=true";
	}

	
	public String logUser() {
		User logUser = userService.findByEmail(user.getEmail(), user.getPassword());
		if(logUser != null){
			
			SessionUtils session = SessionUtils.getInstance();
			session.setAttribute("current_user", logUser);
	        
			return "/home/home?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "index";
		}
	}
	
	public String logOut(){
		SessionUtils session = SessionUtils.getInstance();
		session.invalide();
		return "/index";
	}
}
