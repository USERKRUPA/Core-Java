package tester;

import java.util.*;

import com.app.core.Employee;
import static utils.EmployeeValidator.*;

public class EmployeeTester {

	public static void main(String[] args) {
		/*
		 * Add full time employee Add part time employee Delete an employee by Emp Id
		 * Search employee details by Aadhaar number Display all employee details
		 * Display all employee details sorted by date of joining Exit
		 */
		try (Scanner sc = new Scanner(System.in)) {
			boolean flag = true;
			Map<Integer, Employee> empMap = new HashMap<>();

			while (flag) {
				System.out.println("1. Add full time employee" + "\n2. Add part time employee"
						+ "\n3. Delete an employee by Emp Id" + "\n4. Search employee details by Aadhaar number"
						+ "\n5. Display all employee details"
						+ "\n6. Display all employee details sorted by date of joining" + "\n0. Exit");
				System.out.println("enter your choice:");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Name, Date of joining(yyyy-MM-dd), Phone Number, Aadhaar number, monthly salary");
						Employee emp = validateFTE(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), empMap);
						empMap.put(emp.getEmpId(), emp);
						System.out.println("Employee added..");
						break;
					case 2:
						System.out.println("Enter Name, Date of joining(yyyy-MM-dd), Phone Number, Aadhaar number, hourly salary");
						emp = validatePTE(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),empMap);
						empMap.put(emp.getEmpId(), emp);
						System.out.println("Employee added..");
						break;
					case 3:
						System.out.println("Enter employee id to delete");
						removeEmplyee(sc.nextInt(), empMap);
						break;
					case 4:
						System.out.println("Enter Aadhaar No:");
						String aadhaarNo = sc.next();
						empMap.values().stream().filter(e -> e.getAadharNo().equals(aadhaarNo))
								.forEach(System.out::println);
						break;
					case 5:
						empMap.values().stream().forEach(System.out::println);
						break;
					case 6:
						empMap.values().stream().sorted((e1, e2) -> e1.getDoj().compareTo(e2.getDoj()))
								.forEach(System.out::println);
						break;
					case 0:
						flag = false;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} // Scanner class is auto closable

	}
}
