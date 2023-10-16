package customermgmtsystem.utils;

import java.util.List;

import customermgmtsystem.com.app.core.Customer;
import customermgmtsystem.customer_exception.CustomerMgmtException;

public class CustomerAuthenticationAndOperation {
	public static String authenticateCustomer(String email, String password, List<Customer> customerList) throws CustomerMgmtException {
		Customer customer = findByEmail(email, customerList);
		if(customer.getPassword().equals(password))
			return customer.getFirstName() + " " + customer.getLastName();
		throw new CustomerMgmtException("Invalid Password...");
	}
	public static Customer findByEmail(String email, List<Customer> customerList) throws CustomerMgmtException{
		Customer customer = new Customer(email);
		int index = customerList.indexOf(customer);
		if(index == -1)
			throw new CustomerMgmtException("Enter valid Email Id...");
		return customerList.get(index);
	}
	public static void resetPassword(String email, String password, String newPassword, List<Customer> customerList) throws CustomerMgmtException {
		Customer customer = findByEmail(email, customerList);
		if(customer.getPassword().equals(password)) {
			customer.setPassword(newPassword);
		}
		System.out.println("Password reset done...");
	}
}
