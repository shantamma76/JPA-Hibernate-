package com.xworkz.employee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product_inventory")
public class Productdto {

	@Id
	@GenericGenerator(name = "shanta", strategy = "increment")
	@GeneratedValue(generator = "shanta")
	private int id;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "category")
	private String category;
	private int price;
	private int quantity;
	private String supplier;
	private int reorder_level;
	private String date_added;
	private String description;
	private String expiry_date;

	public Productdto() {
		super();
		System.out.println("No-arg constructor in Productdto");
	}

	public Productdto(String product_name, String category, int price, int quantity, String supplier, int reorder_level,
			String date_added, String description, String expiry_date) {
		super();
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.supplier = supplier;
		this.reorder_level = reorder_level;
		this.date_added = date_added;
		this.description = description;
		this.expiry_date = expiry_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getReorder_level() {
		return reorder_level;
	}

	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

}
