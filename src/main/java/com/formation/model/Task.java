package com.formation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Task {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "PLACE")
	private String place;
	
	@Column(name = "SUCCESS_LEVEL")
	private int successLevel;
	

	@Column(name = "PRIORITY_LEVEL")
	private int priorityLevel;

	@ManyToOne
	private Objectif objectif;
	
	
	public Task(){
		
	}


	public Task(String name, Date startDate, Date endDate, String place, int priorityLevel, Objectif objectif) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.priorityLevel = priorityLevel;
		this.objectif = objectif;
	}
	
	

	// TODO getter and setter
}
