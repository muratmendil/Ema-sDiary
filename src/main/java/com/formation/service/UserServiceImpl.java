package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.UserDao;
import com.formation.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User findByEmail(String email, String password) {
		return userDao.findByEmail(email, password);
	}

	@Override
	public List<User> findById() {
		return null;
	}

	@Override
	public boolean validate(String email, String password) {
		return userDao.validate(email,  password);
	}

}
