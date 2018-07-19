package com.formation.controller;



import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.formation.model.Diary;
import com.formation.model.User;
import com.formation.service.DiaryService;
import com.formation.service.UserService;

@Named
@Controller
@RequestScoped
public class SignUpController {

	private User user;
	
	@Autowired
	private UserService userService;
	
	/*
	@Autowired
	private DiaryService diaryService;*/



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

	
	public String index() {
		return "/login/index";
	}

	public String createUser() {
		Diary diary = new Diary();
		System.out.println("start"+ this.user.getFirstName());
		this.user.setDiary(diary);
	//	diaryService.createDiary(diary);
		User us = userService.createUser(this.user);
		return "/login/index";
	}
}
