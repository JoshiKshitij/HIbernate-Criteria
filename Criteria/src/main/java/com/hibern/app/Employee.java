package com.hibern.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(generator="ice")
	@GenericGenerator(name="ice" , strategy= "increment")
	private int id;
	
	private String name;
	
	private double exp;
	
	@OneToMany(mappedBy ="emp" , cascade= CascadeType.ALL)
	private List<Laptop> laptops = new ArrayList<>();
	
	@ManyToOne
	private Department dept;

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", laptops=" + laptops + ", dept=" + dept + "]";
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


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	public Department getDept() {
		return dept;
	}

	public Employee(String name) {
		super();
		this.name = name;
		
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public Employee(String name, double exp) {
		super();
		this.name = name;
		this.exp = exp;
	}

	public Employee(String name, double exp, Department dept) {
		super();
		this.name = name;
		this.exp = exp;
		this.dept = dept;
	}

}
