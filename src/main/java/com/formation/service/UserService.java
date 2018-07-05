package com.formation.service;


import com.formation.model.User;

public interface UserService {
	User createUser(User user);
	User findById(int id);
	User findByEmail(String email, String password);
}



