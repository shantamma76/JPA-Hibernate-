package com.xworkz.december.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "december_table")
@NamedQuery(name = "findById", query = "select ed from DecEntity ed where ed.id=4")
@NamedQuery(name = "findByName", query = "select ed from DecEntity ed where ed.name='Radhika'")
@NamedQuery(name = "findByEmail", query = "select ed from DecEntity ed where ed.email='ganesh@gmail.com'")
@NamedQuery(name = "findByPhoneNo", query = "select ed from DecEntity ed where ed.phoneNo='953584644'")
@NamedQuery(name = "findByAddress", query = "select ed from DecEntity ed where ed.address='Dwapara'")
@NamedQuery(name = "findByNameAndPhoneNo", query = "select ed from DecEntity ed where ed.name='Radha' and ed.phoneNo='523698741'")
@NamedQuery(name = "findByNameAndEmail", query = "select ed from DecEntity ed where ed.name='Arjun' and ed.email='arjun@gmail.com'")
@NamedQuery(name = "findByPhoneNoAndEmail", query = "select ed from DecEntity ed where ed.phoneNo='996633221' and ed.email='poorna@gmail.com'")
@NamedQuery(name = "findByNameAndAddress", query = "select ed from DecEntity ed where ed.name='Nandini' and ed.address='RR Nagar'")
@NamedQuery(name = "findByEmailAndAddress", query = "select ed from DecEntity ed where ed.email='renu@gmail.com' and ed.address='Yadgir'")
public class DecEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	@Column(name = "phone_no")
	private long phoneNo;
	private int age;
	private String address;

	public DecEntity() {
		System.out.println("No-arg const");
	}

	public DecEntity(String name, String email, long phoneNo, int age, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "DecEntity [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", age=" + age
				+ ", address=" + address + "]";
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
