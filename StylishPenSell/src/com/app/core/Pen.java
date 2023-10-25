package com.app.core;

import java.time.LocalDate;

public class Pen {
	private static int idGenerator;
	private int id;
	private Brand brand;
	private Color color;
	private Color inkColor;
	private Material material;
	private int stock;
	private LocalDate updateDate;
	private LocalDate listingDate;
	private double price;
	private int discount;
	
	static {
		idGenerator = 0;
	}
	
	public Pen(Brand brand, Color color, Color inkColor, Material material, int stock, LocalDate listingDate,
			double price, int discount) {
		super();
		this.id = ++idGenerator;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.updateDate = LocalDate.now();
		this.listingDate = listingDate;
		this.price = price;
		this.discount = discount;
	}
	
	public Pen(Brand brand) {
		super();
		this.brand = brand;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pen))
			return false;
		Pen other = (Pen) obj;
		return brand == other.brand;
	}

	
	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", updateDate=" + updateDate + ", listingDate=" + listingDate
				+ ", price=" + price + ", discount=" + discount + "]";
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public LocalDate getListingDate() {
		return listingDate;
	}

	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}
	
}
