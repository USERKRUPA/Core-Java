package com.app.core;

import java.time.LocalDate;

public class Employee {
//Name, Date of joining, Phone Number, Aadhaar number
	private int empId;
	private String name;
	private LocalDate doj;
	private String mobileNo;
	private String aadhaarNo;
	private static int idGenerator;
	static {
		idGenerator = 0;
	}
	public Employee(String name, LocalDate doj, String mobileNo, String aadhaarNo) {
		super();
		this.empId = ++idGenerator;
		this.name = name;
		this.doj = doj;
		this.mobileNo = mobileNo;
		this.aadhaarNo = aadhaarNo;
	}
	
	public Employee(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	@Override
	public String toString() {
		return "[empId=" + empId + ", name=" + name + ", doj=" + doj + ", mobileNo=" + mobileNo
				+ ", aadhaarNo=" + aadhaarNo ;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getAadharNo() {
		return aadhaarNo;
	}

	public void setAadharNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
}
