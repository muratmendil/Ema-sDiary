package com.formation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Test implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "test_id")
	private int id;

	@Column(name = "testName")
	@Size(min = 2, max = 20)
	private String testName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="test", cascade = CascadeType.ALL)
	private List<Cases> cases = new ArrayList<Cases>();

	public int getId() {
		return id;
	}

	public List<Cases> getCases() {
		return cases;
	}

	public void setCases(List<Cases> cases) {
		this.cases = cases;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", testName=" + testName + ", cases=" + cases + "]";
	}
	
}
