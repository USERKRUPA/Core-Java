package customermgmtsystem.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import custome_ordering.CustomerSortByDobRegAmount;

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
		 * find out the complete names of the customers , who have not paid the subscription (reg amount) , for last 3 months ?
			  Add instance field in Customer : lastSubscriptionPaidDate : LocalDate
			  init : to reg date (LocalDate.now())
 		   6. Add option in tester(customer) : to pay reg / subscription

		7. Add another option (admin) : display complete names of the customers , who have not paid the subscription (reg amount) , for last 3 months ?
		   for-each : 
		   API hint : java.time.Period , between(...) , toTotalMonths()
		
		 8.  How will you remove all those customer details whose subscription is pending for last 6 months?
		   Iterator : remove 
		   API hint : java.time.Period , between(...) , toTotalMonths()
		 * 0. Exit
		 */
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			List<Customer> customerList = populateCustomerList();
			//List<Customer> customerList = new ArrayList<>();
			while(!exit) {
				System.out.println("Customer Options:\n1. Sign up\n2. Sign in (login)\n3. Change Password\n4. Unsubscribe\n"
						+ "5. Display all\n6. Pay subscription \n7. customers who have not paid subscription(Last 3 months:)\n"
						+ "8. Remove customers whose subscription is pending(6 months) \n9. Sort by email \n10. Sort by DoB n reg amount\n0. Exit");
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
					case 6:
						System.out.println("Enter customer email id and reg amount: ");
						paySubscription(sc.next(), sc.nextDouble(), customerList);
						break;
					case 7:
						displayCustomerNotPaidSubscription(customerList);
						break;
					case 8:
						removeCustomerNotPaidSubscription(customerList);
						break;
					case 9:
						//natural ordering
						Collections.sort(customerList);
						break;
					case 10:
						Collections.sort(customerList,new CustomerSortByDobRegAmount());
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
