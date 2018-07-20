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
	@Column(name = "task_id")
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
	

	@ManyToOne
	private Diary diary;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getSuccessLevel() {
		return successLevel;
	}

	public void setSuccessLevel(int successLevel) {
		this.successLevel = successLevel;
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	public Diary getDiary() {
		return diary;
	}

	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	
}
