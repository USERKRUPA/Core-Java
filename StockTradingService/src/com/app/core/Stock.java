package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//stock id (unique : string), stock name (string), company name(string) , 
	//price (double), closing date (Date) , quantity (int)
	private String stockId;
	private String stockName;
	private String cmpnyName;
	private double price;
	private LocalDate closingDate;
	private int quantity;
	
	public Stock(String stockId, String stockName, String cmpnyName, double price, LocalDate closingDate, int quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.cmpnyName = cmpnyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStockId() {
		return stockId;
	}

	public String getCmpnyName() {
		return cmpnyName;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", cmpnyName=" + cmpnyName + ", price="
				+ price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}
		
}
