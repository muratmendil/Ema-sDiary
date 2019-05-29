package com.formation.api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.User;
import com.formation.service.UserService;

@RestController
public class UserApi {
	
	@Autowired UserService userService;
	
	@PostMapping("/login")
	 public ResponseEntity<User> loginUser(@Valid @RequestBody User user){
		try {
			User logUser = userService.findByEmail(user.getEmail(), user.getPassword());
			return ResponseEntity.ok(logUser);
		} catch (ErrorExeption e) {
			return ResponseEntity.ok(new User());
		} 
	 }
	
	@PostMapping("/signUp")
	 public ResponseEntity<User> signUpUser(@Valid @RequestBody User user){
		try {
			User newUser = userService.createUser(user);
			return ResponseEntity.ok(newUser);
		} catch (ErrorExeption e) {
			return ResponseEntity.ok(new User());
		} 
	 }
	
	@GetMapping("test2")
	public User getTest2() {
		try {
			User logUser = userService.findByEmail("dadie.emilin", "toto");
			return logUser;
		} catch (ErrorExeption e) {
			return new User();
		} 	
	}
}
