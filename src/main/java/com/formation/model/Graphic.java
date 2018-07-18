package com.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Graphic  {
	
	@Id
	@GeneratedValue
	@Column(name = "graphic_id")
	private int id;
	
	@Column(name = "AVERAGE")
	private int average;
	
    @ElementCollection(targetClass=Integer.class)
	private List<Integer> data;

}
