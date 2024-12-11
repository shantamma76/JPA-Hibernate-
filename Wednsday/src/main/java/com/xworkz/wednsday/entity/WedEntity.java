package com.xworkz.wednsday.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="wednseday_table")
@NamedQuery(name="getNameById", query="select wd.name from WedEntity wd where wd.id= :id")
@NamedQuery(name="getEmailAndDescriptionByPhone", query="select wd.email, wd.description from WedEntity wd where wd.phone= :phone")
public class WedEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String description;
	private long phone;
	private double salary;
	
	public WedEntity(String name, String email, String description, long phone, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.description = description;
		this.phone = phone;
		this.salary = salary;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "WedEntity [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", phone=" + phone + ", salary=" + salary + "]";
	}

	
}
	