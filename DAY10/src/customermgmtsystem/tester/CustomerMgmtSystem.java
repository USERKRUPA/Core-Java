package customermgmtsystem.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static customermgmtsystem.utils.CustomerAuthenticationAndOperation.*;
import static customermgmtsystem.utils.CustomerValidationRules.validateAllInputs;
import customermgmtsystem.com.app.core.Customer;

public class CustomerMgmtSystem {

	public static void main(String[] args) {
		/*
		 * Customer management system Supply 
		 * Options 
		 * 1. Sign up (customer registration)//first check duplication and then add to list
		 * 2. Sign in (login) // findByEmail check email id and password
		 * i/p : email n password 
		 * 3. Change password //findByEmail check email id, password and then setPassword 
		 * i/p : email n old password n new password 
		 * 4. Unsubscribe customer //remove customer by email i/p : customer email 
		 * 5. Display all customers. //for each loop 
		 * 0. Exit
		 */
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			List<Customer> customerList = new ArrayList<>();
			while(!exit) {
				System.out.println("Customer Options:\n1. Sign up\n2. Sign in (login)\n3. Change Password\n4. Unsubscribe\n5. Display all\n0. Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Customer Details: firstName, lastName, email, password, regAmount, dob, plan");
						Customer customer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),customerList);
						customerList.add(customer);
						System.out.println("Thank you for registration...");
						break;
					case 2:
						System.out.println("Enter Email id and password: ");
						System.out.println("Login Successfully\nWelcome "+ authenticateCustomer(sc.next(), sc.next(), customerList));
						break;
					case 3:
						System.out.println("Enter Email id, password and new password: ");
						resetPassword(sc.next(), sc.next(), sc.next(), customerList);
						break;
					case 4:
						System.out.println("Enter Email Id: ");
						customer = findByEmail(sc.next(), customerList);
						customerList.remove(customer);
						System.out.println("Customer unsubscribed....");
						break;
					case 5:
						for(Customer cust : customerList)
							System.out.println(cust);
						break;
					case 0:
						exit = true;
						break;
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}//sc.close()

	}

}
