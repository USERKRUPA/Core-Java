package com.app.core;

import java.time.LocalDate;

public class PTE extends Employee{
	private int hourPayment;

	public PTE(String name, LocalDate doj, String mobileNo, String aadharNo, int hourPayment) {
		super(name, doj, mobileNo, aadharNo);
		this.hourPayment = hourPayment;
	}

	@Override
	public String toString() {
		return "PTE [ " + super.toString() +" hourPayment=" + hourPayment + "]";
	}
	
}
