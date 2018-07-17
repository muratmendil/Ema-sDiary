package com.formation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Graphic implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "AVERAGE")
	private int average;
	
    @ElementCollection(targetClass=Integer.class)
	private List<Integer> data;

}
