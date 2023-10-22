package utils;

import java.time.LocalDate;
import java.util.Map;

import com.customer.core.Customer;
import com.customer.core.ServicePlan;

import custom_exceptions.CustomExceptionClass;

public class ValidationRules {
	
	public static void findDupCustomer(String email, Map<String, Customer> customerMap) throws CustomExceptionClass{
		if(customerMap.containsKey(email))
			throw new CustomExceptionClass("Email id already registered...");
		System.out.println("Valid email id...");
	}
		
	public static Customer validateAllRules(String firstName, String lastName, String email,  String password, double regAmount, String dob, String plan, Map<String,Customer> customerList) throws CustomExceptionClass {
		LocalDate parsedDob = parseDate(dob);
		ServicePlan parsedPlan = parseAndValidate(plan);
		validateRegAmount(regAmount,parsedPlan);
		return new Customer(firstName, lastName, email, password, regAmount, parsedDob, parsedPlan, LocalDate.now());
	}

	public static void validateRegAmount(double regAmount, ServicePlan parsedPlan) throws CustomExceptionClass {
		if(parsedPlan.getPlanCost() != regAmount)
			throw new CustomExceptionClass("Registration Amount doesn't match with plan.");
	}

	public static ServicePlan parseAndValidate(String plan) throws IllegalArgumentException{
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	public static LocalDate parseDate(String dob) {
		return LocalDate.parse(dob);
	}
	
	public static void validateCustomer(String email, String password, Map<String, Customer> customerMap) throws CustomExceptionClass {
		if(customerMap.containsKey(email)) {
			if(!(customerMap.get(email).getPassword().equals(password))) {
				throw new CustomExceptionClass("Password doesn't match");
			}
		}
		else {
			throw new CustomExceptionClass("Email doesn't exist");
		}	
	}
	
	public static void changePassword(String email, String password, String newPassword, Map<String, Customer> customerMap) throws CustomExceptionClass {
		validateCustomer(email, password, customerMap);
		customerMap.get(email).setPassword(newPassword);
	}
}
