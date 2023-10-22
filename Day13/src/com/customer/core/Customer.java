package com.customer.core;

import java.time.LocalDate;

public class Customer{
	private int custId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmt;
	private LocalDate dob;
	private ServicePlan plan;
	private LocalDate lastSubscriptionPaidDate;
	private static int idGenerator;
	static {
		idGenerator = 0;
	}
	
	public Customer(String firstName, String lastName, String email, String password,double regAmt ,LocalDate dob,
			ServicePlan plan, LocalDate lastsubScriptionDate) {
		super();
		this.custId = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.plan = plan;
		this.regAmt = regAmt;
		this.lastSubscriptionPaidDate = lastsubScriptionDate;
	}
	
	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}

	public double getRegAmt() {
		return regAmt;
	}

	public void setRegAmt(double regAmt) {
		this.regAmt = regAmt;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", plan=" + plan + ", lastSubscriptionPaid="+ lastSubscriptionPaidDate+" ]";
	}

	@Override
	public int compareTo(Customer cust) {
		return this.getEmail().compareTo(cust.getEmail());
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
