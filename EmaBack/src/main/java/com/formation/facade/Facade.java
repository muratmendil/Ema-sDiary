package com.formation.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.config.RootConfig;
import com.formation.service.UserService;

public class Facade {
	
	private ApplicationContext ctx = null;
	
	private static Facade facade= null;
	
	private Facade() {
		ctx = new AnnotationConfigApplicationContext(RootConfig.class);
	}
	
	public static Facade getInstance(){
		
		if (facade == null) {
			facade = new Facade();
		}
		
		return facade;
	}
	
	public UserService getUserService(){
		return ctx.getBean(UserService.class);
	}
	
}
