package com.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstName")
	@Size(min = 2, max = 20)
	private String firstName;
	
	
	@Column(name = "lastName")
	@Size(min = 2, max = 20)
	private String lastName;
	

	@Column(unique=true, name = "email")
	@Size(min = 10, max = 30)
	private String email;
	
	
	@Column(name = "password")
	@Size(min = 4, max = 20)
	private String password;
	
	
	@Column(name = "birthDate")
//	@Size(min = 4, max = 15)
	private String birthDate;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}
