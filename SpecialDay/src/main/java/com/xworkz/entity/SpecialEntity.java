package com.xworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "birth_day")
//@NamedQuery(name = "findByProfessorId", query = "Select ie from specialEntity ie where ie.professorId= :profId")

@NamedQuery(name = "findAll", query = "Select ie from SpecialEntity ie")

@NamedQuery(name = "findNameByGender", query = "Select ie.name from SpecialEntity ie where ie.dop= :getDob")
@NamedQuery(name = "findSalaryById", query = "Select ie.salary From SpecialEntity ie where ie.id = :setId")
@NamedQuery(name = "findMobileNoByName", query = "Select ie.mobileNo from SpecialEntity ie where ie.name= :setName")

public class SpecialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String dob;
	private String gender;

	@Column(name = "mobileNo")
	private long mobile;

	private double salary;

	public SpecialEntity() {
		super();
	}

	public SpecialEntity(String name, String dob, String gender, long mobile, double salary) {
		super();
		// this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
