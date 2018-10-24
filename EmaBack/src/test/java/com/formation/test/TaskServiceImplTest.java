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
import com.formation.model.Task;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.TaskService;
import com.formation.service.UserService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class ) //java config*/
public class TaskServiceImplTest {

	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ObjectifService objectifService;
	
	
	@Autowired
	UserService userService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateTask() {
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
		
		Task task = new Task();
		Objectif ob = new Objectif();
		ob.setName("Espagnol");
		ob.setStartDate("2018/08/22 12:00");
		ob.setEndDate("2018/08/23 12:00");
		ob.setUserId(createUser.getId());

		Task createTask = null;
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		
		task.setName("Verre irréguliers");
		task.setStartDate("2018/08/22 12:00");
		task.setEndDate("2018/08/23 12:00");
		task.setPlace("Paris");
		task.setPriorityLevel(2);
		
		try {
			createTask = taskService.createTask(task);
			Assert.assertNotNull(createTask);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createTask);
		} 
		userService.deleteUser(createUser.getId());

	}

	@Test
	public void testFindById() {
		Task task = null;
		try {
			task = taskService.findById(1);
			Assert.assertNotNull(task);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(task);
			System.out.println(e.getExeptionMessage());
		}
	}

	@Test
	public void testDeleteTask() {
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
		Task task = new Task();
		Objectif ob = new Objectif();
		ob.setName("Espagnol");
		ob.setStartDate("2018/08/22 12:00");
		ob.setEndDate("2018/08/23 12:00");
		ob.setUserId(user.getId());
		
		Task createTask = null;
		Objectif createObjectif = null;
		try {
			createObjectif = objectifService.createObjectif(ob);
			Assert.assertNotNull(createObjectif);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createObjectif);
		} 
		
		task.setName("Verre irréguliers");
		task.setStartDate("2018/08/22 12:00");
		task.setEndDate("2018/08/23 12:00");
		task.setPlace("Paris");
		task.setPriorityLevel(2);
		task.setObjectifId(createObjectif.getId());
		//task.setObjectif(createObjectif);
		try {
			createTask = taskService.createTask(task);
			Assert.assertNotNull(createTask);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			System.out.println(e.getExeptionMessage());
			Assert.assertNull(createTask);
		} 
		int id = task.getId();
		
		taskService.deleteTask(id);
		Task finalTask = null;
		try {
			finalTask = taskService.findById(id);
			Assert.assertNotNull(task);
			System.out.println("Success");
		} catch (ErrorExeption e) {
			Assert.assertNull(finalTask);
			System.out.println(e.getExeptionMessage());
		}
		
		userService.deleteUser(createUser.getId());

	} 
}
