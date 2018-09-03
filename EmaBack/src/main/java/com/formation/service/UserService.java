package com.formation.service;


import java.util.List;

import com.formation.exeption.ErrorExeption;
import com.formation.model.User;

public interface UserService {
	User createUser(User user) throws ErrorExeption;
	User findById(int id);
	User findByEmail(String email, String password) throws ErrorExeption;
	List<User> findById();
	void deleteUser(int id);
}


