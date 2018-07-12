package com.formation.model;

import java.util.Date;
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
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "START_DATE")
	private Date startDate;
	

	@Column(name = "END_DATE")
	private Date endDate;

	@OneToMany(mappedBy="objectif")
	private List<Task> tasks;
	
	
    @ElementCollection(targetClass=Objectif.class)
	private List<Objectif> suggestions;
	
	@OneToOne
	@JoinColumn(name="GRAPH_ID")
	private Graphic graphic;
	
	
	public Objectif(){
		
	}

	public Objectif(String name, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
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
}
