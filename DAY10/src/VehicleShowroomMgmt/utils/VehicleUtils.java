package VehicleShowroomMgmt.utils;

import java.util.List;

import VehicleShowroomMgmt.com.app.core.Vehicle;
import VehicleShowroomMgmt.custom_exceptions.VehicleHandlingException;

public class VehicleUtils{
	public static Vehicle findByChesisNo(String chesisNo, List<Vehicle> vehicleList) throws VehicleHandlingException{
	/*	for(int i = 0; i < vehicleList.size(); i++) {
			Vehicle v = vehicleList.get(i);
			if(v.getChasisNo().equals(chesisNo)) {
				return v;
			}
		}
		throw new VehicleHandlingException("Invalid ch no !!!!");
	*/
		Vehicle v = new Vehicle(chesisNo);
		int index = vehicleList.indexOf(v);
		if(index == -1)
			throw new VehicleHandlingException("Invalid ch no !!!!");
		return vehicleList.get(index); //what if return v; is written
	}
}
