package com.hibern.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class ClassLocation {
	
	@Id
	@GeneratedValue(generator="ice")
	@GenericGenerator(name="ice" , strategy= "increment")
	private int id;
	
	private String stdName;
	
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	@Override
	public String toString() {
		return "ClassLocation [id=" + id + ", stdName=" + stdName + ", location=" + location + "]";
	}

	public ClassLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
