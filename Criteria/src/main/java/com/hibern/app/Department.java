package com.hibern.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Department {

	@Id
	@GeneratedValue(generator="ice")
	@GenericGenerator(name="ice" , strategy= "increment")
	private int id;

	private int noOfEmps;

	private String name;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	private List<Employee> emps = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfEmps() {
		return noOfEmps;
	}

	public void setNoOfEmps(int noOfEmps) {
		this.noOfEmps = noOfEmps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", noOfEmps=" + noOfEmps + ", name=" + name + ", emps=" + emps + "]";
	}

	public Department(int noOfEmps, String name, List<Employee> emps) {
		super();
		this.noOfEmps = noOfEmps;
		this.name = name;
		this.emps = emps;
	}

	public Department(int noOfEmps, String name) {
		super();
		this.noOfEmps = noOfEmps;
		this.name = name;
	}
}
