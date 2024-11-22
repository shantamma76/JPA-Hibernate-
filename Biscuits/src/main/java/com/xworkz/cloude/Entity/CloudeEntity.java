package com.xworkz.cloude.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "besciutes_details")
public class CloudeEntity {

	@Id
	private int id;

	private String besciutes_name;
	private int price;
	private String texture;
	private String shape;
	private String color;
	private String taste;
	private String flavour;
	private String manf_date;
	private String expired_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBesciutes_name() {
		return besciutes_name;
	}

	public void setBesciutes_name(String besciutes_name) {
		this.besciutes_name = besciutes_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public String getManf_date() {
		return manf_date;
	}

	public void setManf_date(String manf_date) {
		this.manf_date = manf_date;
	}

	public String getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}

}