package com.formation.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Objectif {


	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Override
	public String toString() {
		return "Objectif [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

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
	@JoinColumn(name="GRAPH_ID")
	private Graphic graphic;
	
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
}
	

