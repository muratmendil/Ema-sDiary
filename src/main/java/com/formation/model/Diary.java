package com.formation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Diary implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToMany
	@JoinTable(name="DIAR_TASK", joinColumns = @JoinColumn(name= "DIAR_ID"), inverseJoinColumns = @JoinColumn(name="TASK_ID"))
	private List<Task> tasks;
	
	@ManyToOne
	private User user;
}
