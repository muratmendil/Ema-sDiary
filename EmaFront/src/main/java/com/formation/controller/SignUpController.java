package com.formation.controller;



import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.formation.model.User;
import com.formation.service.UserService;

@SuppressWarnings("restriction")
@Named
@Controller
@RequestScoped
public class SignUpController{

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
		System.out.println("++++++++++++++");
		user = new User();
	}

	
	public String index() {
		return "/login/index";
	}
	
	public String goToSignIn() {
		System.out.println("____________");
		return "/index.xhtml?faces-redirect=true";
	}

	public String createUser() {
		System.out.println("debut");
		User user = userService.createUser(this.user);
		if(user != null){
			return "/index";
		}else{
			return "/index";
		}
	}
}
