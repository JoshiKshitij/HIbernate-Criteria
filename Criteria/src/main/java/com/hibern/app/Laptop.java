package com.hibern.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(generator="ice")
	@GenericGenerator(name="ice" , strategy= "increment")
	private int id;

	private String brand;

	private String ram;

	@ManyToOne
	private Employee emp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", ram=" + ram + "]";
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(String brand, String ram, Employee emp) {
		super();
		this.brand = brand;
		this.ram = ram;
		this.emp = emp;
	}

	public Laptop(String brand, String ram) {
		super();
		this.brand = brand;
		this.ram = ram;
	}

}
