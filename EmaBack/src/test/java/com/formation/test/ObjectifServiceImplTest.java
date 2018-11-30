package com.formation.test;

import static org.junit.Assert.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.config.RootConfig;
import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.UserService;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class ) //java config */
public class ObjectifServiceImplTest {
	
	@Autowired
	ObjectifService objectifService;
	
	@Autowired
	UserService userService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateObjectif() {
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
		
		Objectif ob = new Objectif();
		ob.setName("Anglais");
		ob.setStartDate("2018/08/22 12:00");
		ob.setEndDate("2018/08/23 12:00");
		ob.setUserId(createUser.getId());
		
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		userService.deleteUser(createUser.getId());
	}

	@Test
	public void testFindById() {
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
		
		Objectif ob = new Objectif();
		ob.setName("Anglais");
		ob.setStartDate("2018/08/22 12:00");
		ob.setEndDate("2018/08/23 12:00");
		
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		
		
		Objectif findObjectif = null;
		try {
			findObjectif = objectifService.findById(createUser.getId());
			Assert.assertNotNull(findObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(findObjectif);
			System.out.println(e.getExeptionMessage());
		}
		
		userService.deleteUser(createUser.getId());
	}

	@Test
	public void testGetAll() {
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
		
		Objectif ob = new Objectif();
		ob.setName("Francais");
		ob.setStartDate("2018/08/22 12:00");
		ob.setEndDate("2018/08/23 12:00");
		ob.setUserId(createUser.getId());
		
		Objectif ob2 = new Objectif();
		ob2.setName("Espagnole");
		ob2.setStartDate("2018/08/22 12:00");
		ob2.setEndDate("2018/08/23 12:00");
		ob2.setUserId(createUser.getId());
		
		Objectif createObjectif = null;
		Objectif createObjectif2 = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			createObjectif2 = objectifService.createObjectif(ob2);
			Assert.assertNotNull(createObjectif2);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
			Assert.assertNull(createObjectif2);
		} 
		
		List<Objectif> obs = null;
		try {
			obs = objectifService.findByUserId(createUser.getId());
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
		}
		
		userService.deleteUser(createUser.getId());
	} 
}
