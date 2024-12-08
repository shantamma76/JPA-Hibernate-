package com.xworkz.hospital.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "hospital_table")

@NamedQuery(name = "getAll", query = "select gl from HospitalEntity gl")
@NamedQuery(name = "getById", query = "select gl.hospitalName, gl.email from HospitalEntity gl where gl.id= :id")

@NamedQuery(name = "getCountByAge", query = "select count(gl) from HospitalEntity gl where gl.age> :age")

@NamedQuery(name = "getSingleAll", query = "select gl from HospitalEntity gl where gl.id= :id")

@NamedQuery(name = "getAllbyName&Email", query = "select gl from HospitalEntity gl where gl.hospitalName= :name and gl.email= :email")

@NamedQuery(name = "deleteByName&Age", query = "delete from HospitalEntity gl where gl.hospitalName= :name and gl.age= :age")

@NamedQuery(name = "update", query = "update HospitalEntity gl set gl.is_discharged = :is_discharged where gl.email= :email and gl.phoneNo= :phoneNo")

@NamedQuery(name = "updateByName&Email", query = "update HospitalEntity gl set gl.weight= :weight where gl.hospitalName= :name and gl.email= :email")

public class HospitalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "patient_email")
	private String email;

	@Column(name = "p_age")
	private int age;

	@Column(name = "p_weight")
	private float weight;

	private long phoneNo;
	private int room_number;
	private LocalDateTime date_time;
	private double hospital_bill;
	private boolean is_discharged;

	public HospitalEntity() {
		super();
	}

	public HospitalEntity(String hospitalName, String email, int age, float weight, long phoneNo, int room_number,
			LocalDateTime date_time, double hospital_bill, boolean is_discharged) {
		super();
		this.hospitalName = hospitalName;
		this.email = email;
		this.age = age;
		this.weight = weight;
		this.phoneNo = phoneNo;
		this.room_number = room_number;
		this.date_time = date_time;
		this.hospital_bill = hospital_bill;
		this.is_discharged = is_discharged;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}

	public double getHospital_bill() {
		return hospital_bill;
	}

	public void setHospital_bill(double hospital_bill) {
		this.hospital_bill = hospital_bill;
	}

	public boolean isIs_discharged() {
		return is_discharged;
	}

	public void setIs_discharged(boolean is_discharged) {
		this.is_discharged = is_discharged;
	}

	@Override
	public String toString() {
		return "HospitalEntity [id=" + id + ", hospitalName=" + hospitalName + ", email=" + email + ", age=" + age
				+ ", weight=" + weight + ", phoneNo=" + phoneNo + ", room_number=" + room_number + ", date_time="
				+ date_time + ", hospital_bill=" + hospital_bill + ", is_discharged=" + is_discharged + "]";
	}

}
