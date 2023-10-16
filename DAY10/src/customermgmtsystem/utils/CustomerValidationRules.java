package customermgmtsystem.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import customermgmtsystem.com.app.core.Customer;
import customermgmtsystem.com.app.core.ServicePlan;
import customermgmtsystem.customer_exception.CustomerMgmtException;

public class CustomerValidationRules {
	
	//4.1 no dup customers (i.e if the customer tries to register using existing
	// email , throw exception)
	public static void chkDupCustomer(String email, List<Customer> custList) throws CustomerMgmtException{
		Customer customer = new Customer(email);
		if(custList.contains(customer)) 
			throw new CustomerMgmtException("Email already registered...");
		System.out.println("iNSIDE DUP CUSTOMER");
	}
	
	// 4.2 Validate plan : plan must be of supported types
	public static ServicePlan parseAndValidateServicePlan(String plan) throws IllegalArgumentException{
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	// 4.3 reg amount must match with the plan
	public static void validatePlanAmount(double regAmount) throws CustomerMgmtException{
		boolean flag = false;
		ServicePlan [] plans = ServicePlan.values();
		for(ServicePlan plan : plans) {
			if(regAmount == plan.getCharge()) {
				flag = true;
			}		
		}
		if(!flag)
			throw new CustomerMgmtException("Enter valid plan amount...");
	}
	
	public static LocalDate parseAndValidateDateofBirth(String date) throws CustomerMgmtException, DateTimeParseException{
		LocalDate validateDOB = LocalDate.parse(date);
		if(validateDOB.isAfter(LocalDate.of(2005, 1, 1)))
			throw new CustomerMgmtException("Age should be above 18...");
		return validateDOB;
	}
	
	public static Customer validateAllInputs(String firstName, String lastName, String email, String password, double regAmount, String dob,
			String plan, List<Customer> customerList) throws IllegalArgumentException, CustomerMgmtException, DateTimeParseException{
		chkDupCustomer(email, customerList);
		validatePlanAmount(regAmount);
		LocalDate validatedDoB = parseAndValidateDateofBirth(dob);
		ServicePlan validatedPlan = parseAndValidateServicePlan(plan);
		
		return new Customer(firstName, lastName, email, password, regAmount, validatedDoB, validatedPlan);
		
	}
}
