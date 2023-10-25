package com.app.core;

import java.time.LocalDate;

public class FTE extends Employee{
	private int salary;

	public FTE(String name, LocalDate doj, String mobileNo, String aadharNo, int salary) {
		super(name, doj, mobileNo, aadharNo);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FTE [ " + super.toString() +" hourPayment=" + salary + "]";
	}
	
}
