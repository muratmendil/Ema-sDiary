package com.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.formation.model.User;
import com.formation.service.UserService;


@Controller
@SessionAttributes("user")
public class MainController {

	  @Autowired
	  private UserService service;
	  
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String defaultPage(ModelMap model) {
		  	model.addAttribute("user", new User());
	        return "index";
	  }
	  
	  @RequestMapping(value = "index", method = RequestMethod.GET)
	    public String signInPage(ModelMap model) {
		  	model.addAttribute("user", new User());
	        return "index";
	  }
	  
	  
	  @RequestMapping(value ="/index" , method = RequestMethod.POST)
	    public String signInUser(@ModelAttribute User user, BindingResult result) {
	 
	        User us = service.findByEmail(user.getEmail(), user.getPassword());
	        if(us != null){
		        return "profil";
	        }
	        return null;
	    }
	  
	  @RequestMapping(value ="/signUp" , method = RequestMethod.POST)
	    public String signUpUser(@ModelAttribute User user, BindingResult result) {
	        service.createUser(user);
	        return "index";
	    }
	  
	  
	  @RequestMapping(value = "/signUp", method = RequestMethod.GET)
	    public String signUp(ModelMap model) {
		  	model.addAttribute("user", new User());
	        return "signUp";
	    }
	  
	  
	  @RequestMapping(value = "/profil", method = RequestMethod.GET)
	    public String profil() {
	        return "profil";
	    }
	  
	  @RequestMapping(value = "/article", method = RequestMethod.GET)
	    public String article() {
	        return "article";
	    }
}
