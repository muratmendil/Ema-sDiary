package com.formation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "place")
	private String place;
	
	@Column(name = "successLevel")
	private int successLevel;
	

	@Column(name = "priorityLevel")
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
