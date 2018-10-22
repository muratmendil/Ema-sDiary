package com.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.transaction.annotation.Transactional;


@Entity
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	

	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "endDate")
	private String endDate;

	@Column(name = "place")
	private String place;
	
	@Column(name = "successLevel")
	private int successLevel;

	@Column(name = "priorityLevel")
	private int priorityLevel;



	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
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

	public void setEndDate(String endDate) {
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

	
	public boolean fieldNotEmpty(){
		if(this.name != null && this.startDate != null && this.endDate != null && this.place != null){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", place="
				+ place + ", successLevel=" + successLevel + ", priorityLevel=" + priorityLevel+"]";
	}
}
