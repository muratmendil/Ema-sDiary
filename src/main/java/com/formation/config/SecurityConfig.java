package com.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth
    		.inMemoryAuthentication()
    		.withUser("bill")
    		.password("bill")
    		.roles("USER");
        auth
        	.inMemoryAuthentication()
        	.withUser("admin")
        	.password("admin")
        	.roles("ADMIN");
        auth
        	.inMemoryAuthentication()
        	.withUser("dba")
        	.password("dba")
        	.roles("ADMIN","DBA");//dba à 2 roles !!.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.authorizeRequests()
        .antMatchers("/", "/home").permitAll() 
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .and().formLogin().loginPage("/login")
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
    
}
