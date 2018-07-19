package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.DiaryDao;
import com.formation.dao.UserDao;
import com.formation.model.Diary;
import com.formation.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DiaryDao diaryDao;

	@Override
	public User createUser(User user) {
		User newUser =  user;
		Diary diary = new Diary();
		diary.setName(newUser.getFirstName());
		Diary diar = diaryDao.createDiary(diary);
		newUser.setDiary(diar);
		User finalUser = userDao.createUser(newUser);
		return finalUser;
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
