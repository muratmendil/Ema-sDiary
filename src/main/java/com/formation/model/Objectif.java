package com.formation.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Objectif implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue
	@Column(name = "objectif_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "endDate")
	private String endDate;

	@OneToMany(mappedBy="objectif")
	private List<Task> tasks;
	
	
    @ElementCollection(targetClass=Objectif.class)
	private List<Objectif> suggestions;
	
	@OneToOne
	@JoinColumn(name="graphic_id")
	private Graphic graphic;
	
	
	@ManyToOne
	private User user;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	
	public void reset(){
		this.name = "";
		this.startDate = null;
		this.endDate = null;
	}
	

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Objectif [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
	

