package com.formation.dao;


import com.formation.model.User;

public interface UserDao{
	User createUser(User user);
	User findById(int id);
	User findByEmail(String email, String password);
	String logout();
	boolean validate(String email, String password);
}