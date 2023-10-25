package com.app.core;

public class Order {
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	private static int autoIdGenerator;
	static {
		autoIdGenerator = 0;
	}
	public Order(int petId, int quantity, Status status) {
		super();
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
		this.orderId = ++autoIdGenerator;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	
}
