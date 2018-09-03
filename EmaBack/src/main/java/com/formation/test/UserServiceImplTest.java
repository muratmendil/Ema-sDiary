package com.formation.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.config.RootConfig;
import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.User;
import com.formation.service.UserService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class ) //java config
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
		
		userService.deleteUser(createUser.getId());
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
		userService.deleteUser(createUser.getId());
	}

	@Test
	public void testFindById() {
		
	}
}
