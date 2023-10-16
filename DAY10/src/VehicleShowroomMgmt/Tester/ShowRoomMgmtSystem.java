package VehicleShowroomMgmt.Tester;

import java.util.*;
import VehicleShowroomMgmt.com.app.core.Vehicle;
import static VehicleShowroomMgmt.utils.VehicleUtils.*;
import static VehicleShowroomMgmt.utils.VehicleValidationRules.validateAllInputs;

public class ShowRoomMgmtSystem {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Vehicle> vehicleList = new ArrayList<>();
			boolean exit = false;
			while (!exit) {
				// servicing phase : UI
				System.out.println("Options : 1 . Add a vehicle 2.Display All \n" + "3. Get Specific Vehicle details \n"
						+ "4. Apply discount 0.Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter vehicle details :  chasisNo,  "
								+ "vehicleClr,  basePrice,  manufactureDate, company");
						Vehicle v = validateAllInputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),
								vehicleList);
						vehicleList.add(v);
						System.out.println("Vehicle Added...");
						break;
					case 2:
						System.out.println("========Vehicle Details=========");
						for (Vehicle vehicle : vehicleList) {
							System.out.println(vehicle);
						}
						break;
					case 3:
						System.out.println("Enter chesis no:");
						Vehicle vehicle = findByChesisNo(sc.next(), vehicleList);
						System.out.println(vehicle);
						break;
					case 4:
						System.out.println("Enter Chesis No: ");
						vehicle = findByChesisNo(sc.next(), vehicleList);
						System.out.println("Enter disount: ");
						vehicle.setBasePrice(vehicle.getBasePrice() - sc.nextInt());
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}//sc.close()

	}

}
