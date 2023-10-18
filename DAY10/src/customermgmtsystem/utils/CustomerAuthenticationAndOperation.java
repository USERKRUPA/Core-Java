package customermgmtsystem.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import customermgmtsystem.com.app.core.Customer;
import customermgmtsystem.com.app.core.ServicePlan;
import customermgmtsystem.customer_exception.CustomerMgmtException;

public class CustomerAuthenticationAndOperation {
	public static List<Customer> populateCustomerList(){
		List<Customer> customerList = new ArrayList<>();
		//firstName, lastName, email, password, regAmount, dob, plan
		customerList.add(new Customer("Krupa", "Krupa", "kthumar17@gmail.com", "krupa", 1000.0, LocalDate.of(1991, 5, 17), ServicePlan.valueOf("SILVER")));
		customerList.add(new Customer("Sakshi", "Sakshi", "sakshi@gmail.com", "sakshi", 5000, LocalDate.of(2001, 6, 21), ServicePlan.valueOf("DIAMOND")));
		customerList.add(new Customer("Shraddha", "Shraddha", "shraddha@gmail.com", "shraddha", 2000, LocalDate.of(1998, 1, 3), ServicePlan.valueOf("GOLD")));
		customerList.add(new Customer("Shivani", "Shivani", "Shivani@gmail.com", "shivani", 1000, LocalDate.of(1994, 7, 21), ServicePlan.valueOf("SILVER")));
		customerList.add(new Customer("Ravi", "Ravi", "Ravi@gmail.com", "ravi", 2000, LocalDate.of(2001, 6, 21), ServicePlan.valueOf("SILVER")));
		return customerList;
	}
	public static String authenticateCustomer(String email, String password, List<Customer> customerList)
			throws CustomerMgmtException {
		Customer customer = findByEmail(email, customerList);
		if (customer.getPassword().equals(password))
			return customer.getFirstName() + " " + customer.getLastName();
		throw new CustomerMgmtException("Invalid Password...");
	}

	public static Customer findByEmail(String email, List<Customer> customerList) throws CustomerMgmtException {
		Customer customer = new Customer(email);
		int index = customerList.indexOf(customer);
		if (index == -1)
			throw new CustomerMgmtException("Enter valid Email Id...");
		return customerList.get(index);
	}

	public static void resetPassword(String email, String password, String newPassword, List<Customer> customerList)
			throws CustomerMgmtException {
		Customer customer = findByEmail(email, customerList);
		if (customer.getPassword().equals(password)) {
			customer.setPassword(newPassword);
		}
		System.out.println("Password reset done...");
	}

	public static void paySubscription(String email, double regAmount, List<Customer> customerList) throws CustomerMgmtException{
		Customer customer = findByEmail(email, customerList);
		// validation of regAmount with plan is pending
		double amount =customer.getPlan().getCharge();
		if (amount != regAmount)
				throw new CustomerMgmtException("Invalid reg amount for ypur plan...\nYour plan amount is: " + amount);
		customer.setRegAmount(regAmount);
		customer.setLastSubscriptionPaidDate(LocalDate.now());
	}

	public static void displayCustomerNotPaidSubscription(List<Customer> customerList) {
		System.out.println("Customer List who have not paid subscription amount for last 3 months:");
		for (Customer c : customerList) {
			if ((Period.between(c.getLastSubscriptionPaidDate(), LocalDate.now())).toTotalMonths() >= 3)
				System.out.println(c.getFirstName() + " " + c.getLastName());
		}
	}
	
	public static void removeCustomerNotPaidSubscription(List<Customer> customerList) {
		Customer c;
		Iterator<Customer> itr = customerList.iterator();
		while(itr.hasNext()) {
			c = itr.next();
			if ((Period.between(c.getLastSubscriptionPaidDate(), LocalDate.now())).toTotalMonths() >= 6)
				itr.remove();
			//	System.out.println(c.getFirstName() + " " + c.getLastName());
		}
	}
}
