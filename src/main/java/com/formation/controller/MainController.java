package com.formation.controller;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Id;
=======
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
>>>>>>> d2ea29f04d45eb977657f9298113736130d0d485
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.model.Objectif;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.UserService;

@Named
@Controller
@RequestScoped
public class MainController {

<<<<<<< HEAD
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
=======
	
	private User user;
	private Objectif objectif;
>>>>>>> d2ea29f04d45eb977657f9298113736130d0d485

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

<<<<<<< HEAD
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String signInUser(@ModelAttribute User user, BindingResult result,ModelMap model) {
		System.out.println("***** iciiii ****");
		User us = service.findByEmail(user.getEmail(), user.getPassword());
		System.out.println("** "+us);
		if (us != null) {
			model.addAttribute("users", us);
			return "profil";
		}
		return null;
=======
	public void setUser(User user) {
		this.user = user;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
>>>>>>> d2ea29f04d45eb977657f9298113736130d0d485
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
	
	public String goToSignUp() {
		return "signUp";
	}

<<<<<<< HEAD
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profil(ModelMap model) {
		
        List<User> users = service.findById();
        model.addAttribute("users", users);
        
      
		return "profil";
=======
	public String logUser() {

		User logUser = null;

		logUser = userService.findByEmail(user.getEmail(), user.getPassword());
		if (logUser != null) {
			return "home";
		}
		return null;
>>>>>>> d2ea29f04d45eb977657f9298113736130d0d485
	}
	
	
	public String createUser() {
	User us = userService.createUser(this.user);
		
		return "index";
	}
	
	
	public String createObjectif() {
		System.out.println(this.objectif);
		Objectif obj = this.objectifService.createObjectif(this.objectif);
		return "home";
	}
	
	
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

}
