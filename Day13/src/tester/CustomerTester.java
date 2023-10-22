package tester;

import java.util.Map;
import java.util.Scanner;

import com.customer.core.Customer;
import static utils.ValidationRules.*;
import static utils.UpdateCustomerData.*;

public class CustomerTester {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			Map<String, Customer> customerMap = populateCustomerMap();
			//List<Customer> customerList = new ArrayList<>();
			while(!exit) {
				System.out.println("Customer Options:\n1. Sign up\n2. Sign in (login)\n3. Change Password\n4. Unsubscribe\n"
						+ "5. Display all\n6. Pay subscription \n7. customers who have not paid subscription(Last 3 months:)\n"
						+ "8. Remove customers whose subscription is pending(6 months) \n9. Sort by email \n10. Sort by DoB n reg amount\n0. Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter your email id: ");
						String email = sc.next();
						findDupCustomer(email , customerMap);
						System.out.println("Enter Customer Details: firstName, lastName, password, regAmount, dob, plan");
						Customer customer = validateAllRules(sc.next(), sc.next(), email, sc.next(), sc.nextDouble(), sc.next(), sc.next(),customerMap);
						customerMap.put(email, customer);
						System.out.println("Customer registered with email id " + email);
						break;
					case 2:
						System.out.println("Enter email id and password: ");
						validateCustomer(sc.next(), sc.next(), customerMap);
						System.out.println("Login successfully");
						break;
					case 3:
						System.out.println("Enter email id, old password, new password: ");
						changePassword(sc.next(), sc.next(), sc.next(), customerMap);
						System.out.println("Password set successfully");
						break;
					case 4:
						System.out.println("Enter email id and password: ");
						unsubscribeCustomer(sc.next(), sc.next(), customerMap);
						break;
					case 5:
						customerMap.forEach((custId , cust) -> System.out.println(cust));
						break;
					case 6:
						System.out.println("Enter email id, password and regAmount: ");
						paySubscription(sc.next(), sc.next(), sc.nextDouble(), customerMap);
						System.out.println("Subscription done...");
						break;
					case 7:
						showNotPaidSubscriptionLastThreeMonths(customerMap);
						break;
					case 8:
						rmNotPaidSubsciptionLastSixMonths(customerMap);
						break;
					case 9:
						sortByEmail(customerMap);
						break;
					case 10:
						sortByDobRegAmount(customerMap);
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
