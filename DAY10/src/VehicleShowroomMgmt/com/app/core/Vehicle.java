package VehicleShowroomMgmt.com.app.core;

import java.time.LocalDate;

public class Vehicle {
//chasisNo(string) : Unique ID, color(enum) , basePrice(double) , manufactureDate(Date),company,isAvailable
	private String chasisNo;
	private Color color;
	private double basePrice;
	private LocalDate manuDate;
	private String company;
	private boolean isAvailable;
	
	public Vehicle(String chasisNo, Color color, double basePrice, LocalDate manuDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.color = color;
		this.basePrice = basePrice;
		this.manuDate = manuDate;
		this.company = company;
		this.isAvailable = true;
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public Vehicle(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", color=" + color + ", netprice=" + (getBasePrice() + color.getCost()) + ", manuDate="
				+ manuDate + ", company=" + company + ", isAvailable=" + isAvailable + "]";
	}

	public double getBasePrice() {
		return basePrice;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vehicle) {
			Vehicle vehicleObj = (Vehicle)obj; 
			return this.chasisNo.equals(vehicleObj.chasisNo);
		}
		return false;
	}
}
