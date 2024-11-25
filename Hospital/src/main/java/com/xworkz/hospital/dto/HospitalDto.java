package com.xworkz.hospital.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital_info")
public class HospitalDto {
     
	@Id
	private int id;
	
	@Column(name="hospital_name")
	private String hospital_name;
	
	@Column(name="noOfPatience")
	private int noOfPatience;
	
	@Column(name="noOfDoctores")
	private int noOfDoctores;
	
	@Column(name="location")
	private String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public int getNoOfPatience() {
		return noOfPatience;
	}
	public void setNoOfPatience(int noOfPatience) {
		this.noOfPatience = noOfPatience;
	}
	public int getNoOfDoctores() {
		return noOfDoctores;
	}
	public void setNoOfDoctores(int noOfDoctores) {
		this.noOfDoctores = noOfDoctores;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
}
