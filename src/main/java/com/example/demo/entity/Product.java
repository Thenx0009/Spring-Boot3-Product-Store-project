package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "brand")
	private String brand;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private double price;

	@Column(name = "description")
	private String description;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "image_file_name")
	private String imageFileName;

	// constructors
	public Product() {

	}

	public Product(String name, String brand, String category, double price, String description, Date createdAt,
			String imageFileName) {
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.description = description;
		this.createdAt = createdAt;
		this.imageFileName = imageFileName;
	}

	// generate getters/setters
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", price="
				+ price + ", description=" + description + ", createdAt=" + createdAt + ", imageFileName="
				+ imageFileName + "]";
	}

}
