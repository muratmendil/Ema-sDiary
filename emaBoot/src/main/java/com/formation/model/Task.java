package com.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private int id;
	
	@Column(name = "title")
	private String title;
	

	@Column(name = "start")
	private String start;
	
	@Column(name = "end")
	private String end;

	@Column(name = "place")
	private String place;
	
	@Column(name = "successLevel")
	private int successLevel;

	@Column(name = "priorityLevel")
	private int priorityLevel;
	
	@Column(name = "objectifColor")
	private String objectifColor;

	@Column(name = "objectif_id")
	private int objectifId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public boolean fieldNotEmpty(){
		if(this.title != null && this.start != null && this.end != null && this.place != null){
			return true;
		}
		return false;
	}

	public int getObjectifId() {
		return objectifId;
	}

	public void setObjectifId(int objectifId) {
		this.objectifId = objectifId;
	}

	
	public String getObjectifColor() {
		return objectifColor;
	}

	public void setObjectifColor(String objectifColor) {
		this.objectifColor = objectifColor;
	}

	
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + ", place="
				+ place + ", successLevel=" + successLevel + ", priorityLevel=" + priorityLevel + ", objectifColor="
				+ objectifColor + ", objectifId=" + objectifId + "]";
	}

}
