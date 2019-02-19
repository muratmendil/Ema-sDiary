package com.formation.api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.User;
import com.formation.service.UserService;

@RestController
public class UserApi {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	 public User loginUser(@Valid @RequestBody User user){
		try {
			return userService.findByEmail(user.getEmail(), user.getPassword());
		} catch (ErrorExeption e) {
			return new User();
		} 
	 }
	
	@PostMapping("/signUp")
	 public User signUpUser(@Valid @RequestBody User user){
		try {
			return userService.createUser(user);
		} catch (ErrorExeption e) {
			return new User();
		} 
	 }
}
