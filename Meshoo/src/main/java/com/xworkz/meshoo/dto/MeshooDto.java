package com.xworkz.meshoo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_details")

public class MeshooDto {

	@Id
	@GenericGenerator(name = "shanta", strategy = "increment")
	@GeneratedValue(generator = "shanta")
	private int id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_cost")
	private double cost;

	private int quantity;
	private String color;
	private String brand;

	public MeshooDto() {
		System.out.println("no-arg const in MeshooDto");
	}

	public MeshooDto(String itemName, double cost, int quantity, String color, String brand) {
		super();
		this.itemName = itemName;
		this.cost = cost;
		this.quantity = quantity;
		this.color = color;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
