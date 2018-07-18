package com.formation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import com.formation.service.SessionUtils;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;

	@Column(name = "firstName")
	@Size(min = 2, max = 20)
	private String firstName;

	@Column(name = "lastName")
	@Size(min = 2, max = 20)
	private String lastName;

	@Column(unique = true, name = "email")
	@Size(min = 10, max = 30)
	private String email;

	@Column(name = "password")
	@Size(min = 4, max = 20)
	private String password;

	@Column(name = "birthDate")
	private String birthDate;


	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="diary_id")
	private Diary diary;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Objectif> objectifs;
	
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
	
	public List<Objectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	
	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", birthDate=" + birthDate + ", objectifs=" + objectifs + "]";
	}
	
	
}
