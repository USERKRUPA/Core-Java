package VehicleShowroomMgmt.utils;

import VehicleShowroomMgmt.com.app.core.Color;
import VehicleShowroomMgmt.com.app.core.Vehicle;
import VehicleShowroomMgmt.custom_exceptions.VehicleHandlingException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
import java.util.List;

public class VehicleValidationRules {
	// 4.1 No dup vehicles should be added in the showroom
	public static void chkDup(String chesisNo, List<Vehicle> vehicles) throws VehicleHandlingException {
		Vehicle newVehicle = new Vehicle(chesisNo);
		if (vehicles.contains(newVehicle))// implicitly calls equals() method of Vehicle class
			throw new VehicleHandlingException("Chesis no already available!!!");
		System.err.println("No duplications...");
	}

	// 4.2 manufactureDate : must be after 1st Jan 2020
	public static LocalDate parseAndValidateDate(String date)
			throws VehicleHandlingException, DateTimeParseException {
		LocalDate manuDate = LocalDate.parse(date);
		LocalDate chkDate = LocalDate.of(2020, 1, 1);
		if (manuDate.isBefore(chkDate))
			throw new VehicleHandlingException("Manufacturing date is older...");
		return manuDate;
	}

	// 4.3 Vehicle color must be valid
	public static Color parseAndValidateColor(String col) throws IllegalArgumentException {
		return Color.valueOf(col.toUpperCase());
	}

	public static Vehicle validateAllInputs(String chasisNo, String color, double basePrice, String manuDate,
			String company, List<Vehicle> vehicleList) throws VehicleHandlingException, IllegalArgumentException, DateTimeParseException {
		chkDup(chasisNo, vehicleList);
		LocalDate dt = parseAndValidateDate(manuDate);
		Color col = parseAndValidateColor(color);
		return new Vehicle(chasisNo, col, basePrice, dt, company);
	}
	
}
