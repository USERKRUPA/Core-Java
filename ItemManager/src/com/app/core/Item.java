package com.app.core;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private String itemCode;
	private String desc;
	private double Price;
	private Date shipmentDate;
	
	public Item(String itemCode, String desc, double price, Date shipmentDate) {
		super();
		this.itemCode = itemCode;
		this.desc = desc;
		Price = price;
		this.setShipmentDate(shipmentDate);
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", desc=" + desc + ", Price=" + Price + ", shipmentDate=" + shipmentDate
				+ "]";
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	

}
