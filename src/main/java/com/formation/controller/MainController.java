package com.formation.controller;

<<<<<<< HEAD
=======
import java.util.List;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
>>>>>>> acc7cdd0f0e50b04ac7edd63728db073ae10bf4f

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.formation.model.User;
import com.formation.service.UserService;

@Controller
@SessionAttributes("user")
public class MainController {

<<<<<<< HEAD
	  @Autowired
	  private UserService userService;

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
	 
	        User us = userService.findByEmail(user.getEmail(), user.getPassword());
	        if(us != null){
		        return "home";
	        }
	        return null;
	    }
	  
	  @RequestMapping(value ="/signUp" , method = RequestMethod.POST)
	    public String signUpUser(@ModelAttribute User user, BindingResult result) {
	        userService.createUser(user);
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
=======
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

	@Autowired
	UserService service;

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

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String signInUser(@ModelAttribute User user, BindingResult result) {

		User us = service.findByEmail(user.getEmail(), user.getPassword());
		if (us != null) {
			return "profil";
		}
		return null;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
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
	public String profil(ModelMap model) {
		

        List<User> users = service.findById();
        model.addAttribute("users", users);
        
      
		return "profil";
	}
	


	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String article() {
		return "article";
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

>>>>>>> acc7cdd0f0e50b04ac7edd63728db073ae10bf4f
}
