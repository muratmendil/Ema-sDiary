package com.formation.service;


import java.util.List;

import com.formation.model.User;

public interface UserService {
	User createUser(User user);
	User updateUser(User user);
	User findById(int id);
	User findByEmail(String email, String password);
	List<User> findById();
}



