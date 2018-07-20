package com.formation.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.config.RootConfig;
import com.formation.model.User;
import com.formation.service.UserService;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class LoginTest {
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(LoginTest.class);

	@Autowired
	UserService repo;

	@Test
	public void test() {
		User yarrak = repo.findByEmail("larenaa@live.fr", "12345");
		Assert.assertNotNull(yarrak);

		logger.info(yarrak.toString());
	}
}
