package com.formation.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Objectif implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "objectif_id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "startDate")
	private String startDate;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "endDate")
	private String endDate;

	@ManyToOne
	@JsonManagedReference
	private User user;
	
	private String color;
	

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void reset(){
		this.name = "";
		this.startDate = null;
		this.endDate = null;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public boolean fieldNotEmpty(){
		if(this.name != null && this.startDate != null && this.endDate != null){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Objectif [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", color=" + color + "]";
	}
	
}
	
