package com.iventory.model;

import javax.persistence.*;

@Entity
@Table(name="products")  // table name
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String des;
	private double price;
	private double quantity;
	
	public Product() {}
	
	public Product(String name, String des, double price, double quantity) {
		this.name=name;
		this.des=des;
		this.price=price;
		this.quantity=quantity;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des=des;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity=quantity;
	}
}
