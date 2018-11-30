package com.formation.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.UserDao;
import com.formation.exeption.ErrorExeption;
import com.formation.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) throws ErrorExeption {
		if(user.newAccountfieldNotEmpty()){
			return userDao.createUser(user);
		}
		throw new ErrorExeption("Champs vide", "Un ou plusieurs champs sont vide");
	}

	@Override
	public User findById(int id) throws ErrorExeption{
		User user = userDao.findById(id);
		if(user != null){
			return user;
		}
		throw new ErrorExeption("User inexistant", "ce user n'existe pas");
	}

	@Override
	public User findByEmail(String email, String password) throws ErrorExeption {
		if(email != null  && password != null){
			return userDao.findByEmail(email, password);
		}
		throw new ErrorExeption("Champs vide", "Un ou plusieurs champs sont vide");
	}

	@Override
	public List<User> findById() {
		return null;
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}
