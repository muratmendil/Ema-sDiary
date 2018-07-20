package com.formation.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
		User logUser = userDao.findByEmail(email, password);
		if (logUser != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("firstName",logUser.getFirstName());
			session.setAttribute("lastName",logUser.getLastName());
			session.setAttribute("email",logUser.getEmail());
			session.setAttribute("userId", logUser.getId());
			session.setAttribute("birthDate", logUser.getBirthDate());
			return logUser;
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return new User();
		}
	}

	@Override
	public List<User> findById() {
		return null;
	}

}
