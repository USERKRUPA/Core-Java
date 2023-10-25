package utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Employee;
import com.app.core.PTE;

import exception_handling.EmployeeHandlingException;

import com.app.core.FTE;

public interface EmployeeValidator {
	//Name, Date of joining, Phone Number, Aadhaar number, monthly salary
	static Employee validateFTE(String name, String doj, String mobileNo, String aadhaarNo, int salary, Map<Integer, Employee> empMap) throws EmployeeHandlingException {
		LocalDate parsedDoj = parseDate(doj);
		validateMoNo(mobileNo);
		validateAndChkAadhaarNo(aadhaarNo, empMap);
		return new FTE(name, parsedDoj, mobileNo, aadhaarNo, salary);
	}
	
	static Employee validatePTE(String name, String doj, String mobileNo, String aadhaarNo, int salary, Map<Integer, Employee> empMap) throws EmployeeHandlingException {
		LocalDate parsedDoj = parseDate(doj);
		validateMoNo(mobileNo);
		validateAndChkAadhaarNo(aadhaarNo, empMap);
		return new PTE(name, parsedDoj, mobileNo, aadhaarNo, salary);
	}
	static void validateAndChkAadhaarNo(String aadhaarNo, Map<Integer, Employee> empMap) throws EmployeeHandlingException {
		/* Aadhaar number should be all numeric and of length 12 only, 
		 * there should not be any space in between. 
		 * Hint : Can use a reg ex : ^\\S+$ n use String class's matches method
		 */
		String regEx = "^\\S+$";
		if(aadhaarNo.length() != 12 || !aadhaarNo.matches(regEx))
			throw new EmployeeHandlingException("Invalid aadhaar no...Enter 12 digit aadhar number");		
		for(Employee emp : empMap.values()) {
			if(emp.getAadharNo().equals(aadhaarNo))
				throw new EmployeeHandlingException("Duplicate Aadhaar found...");
		}
	}

	static void validateMoNo(String mobileNo) throws EmployeeHandlingException {
		/*
		 * Phone number should be all numeric and of length 10 Hint : Can use a reg ex :
		 * ^[0-9]*$ n use String class's matches method */
		String regEx = "^[0-9]*$";
		if(mobileNo.length() != 10 || !(mobileNo.matches(regEx)))
			throw new EmployeeHandlingException("Enter 10 digit mobile no.");
	}

	static LocalDate parseDate(String doj) {
		return LocalDate.parse(doj);
	}

	static void removeEmplyee(int empId, Map<Integer, Employee> empMap) throws EmployeeHandlingException {
		//Employee emp = empMap.get(empId);
		if(empMap.get(empId) == null)
			throw new EmployeeHandlingException("Enter valid employee id:");
		empMap.remove(empId);
		System.out.println("Employee entry deleted");
	}
}
