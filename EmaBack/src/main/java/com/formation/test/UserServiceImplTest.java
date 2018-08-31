package com.formation.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.User;
import com.formation.service.UserService;

import junit.framework.Assert;

public class UserServiceImplTest {

	@Autowired
	UserService userService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstName("Ema");
		user.setLastName("Diary");
		user.setPassword("nextadvance");
		user.setBirthDate("4 novembre");
		user.setEmail("ema@gmail.com");
		User createUser = null;
		try {
			createUser = userService.createUser(user);
			Assert.assertNotNull(createUser);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createUser);
		} 
		userService.deleteTask(createUser.getId());
	}

	@Test
	public void testFindByEmail(){
		User user = new User();
		user.setFirstName("Ema");
		user.setLastName("Diary");
		user.setPassword("nextadvance");
		user.setBirthDate("2018");
		user.setEmail("ema@gmail.com");
		User createUser = null;
	
		try {
			createUser = userService.createUser(user);
			Assert.assertNotNull(createUser);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createUser);
		} 
		User findUser = null;
		try {
			findUser = userService.findByEmail(createUser.getEmail(), createUser.getPassword());
			Assert.assertNotNull(findUser);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(findUser);
			System.out.println(e.getExeptionMessage());
		}
		userService.deleteTask(createUser.getId());
	}

	@Test
	public void testFindById() {
		
	}
}
