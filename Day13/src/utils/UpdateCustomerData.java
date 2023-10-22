package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static utils.ValidationRules.*;
import com.customer.core.Customer;
import com.customer.core.ServicePlan;

import custom_exceptions.CustomExceptionClass;

public interface UpdateCustomerData {
	
	static List<Customer> populateCustomerList(){
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer("akash", "thumar", "akash@gmail.com", "akash", 2000, LocalDate.parse("1993-10-04"), ServicePlan.valueOf("GOLD"), LocalDate.of(2023, 2, 10)));
		customerList.add(new Customer("krishna", "vaishnav", "krishna@gmail.com", "krishna", 1000, LocalDate.parse("1992-08-04"), ServicePlan.valueOf("SILVER"), LocalDate.of(2023, 6, 10)));
		customerList.add(new Customer("pooja", "vaishnav", "pooja@gmail.com", "pooja", 5000, LocalDate.parse("1990-08-14"), ServicePlan.valueOf("DIAMOND"), LocalDate.of(2023, 4, 10)));
		customerList.add(new Customer("tina", "gupta", "tina@gmail.com", "tina", 10000, LocalDate.parse("1995-03-10"), ServicePlan.valueOf("PLATINUM"), LocalDate.of(2023, 8, 20)));
		customerList.add(new Customer("rita", "sinha", "rita@gmail.com", "rita", 2000, LocalDate.parse("1995-03-10"), ServicePlan.valueOf("GOLD"), LocalDate.of(2023, 9, 20)));
		return customerList;
	}
	static Map<String, Customer> populateCustomerMap(){
		Map<String, Customer> customerMap = new HashMap<String, Customer>();
		List<Customer> customerList=  populateCustomerList();
		for(Customer customer : customerList) {
			customerMap.put(customer.getEmail(), customer);
		}
		return customerMap;
	}
	
	static void unsubscribeCustomer(String email, String password, Map<String, Customer> customerMap) throws CustomExceptionClass {
		validateCustomer(email, password, customerMap);
		customerMap.remove(email);
		System.out.println("Customer with email id " + email + " unsubscribed...");
	}
	
	static void paySubscription(String email, String password, double regAmount, Map<String, Customer> customerMap) throws CustomExceptionClass {
		validateCustomer(email, password, customerMap);
		Customer customer = customerMap.get(email);
		if(customer.getRegAmt() == regAmount)
			customer.setLastSubscriptionPaidDate(LocalDate.now());
	}
	
	static void showNotPaidSubscriptionLastThreeMonths(Map<String, Customer>customerMap) {
		customerMap.values()
		.stream()
		.filter(customer -> Period.between(customer.getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths() > 3)
		.forEach(customer -> System.out.println(customer));
	}
	
	public static void rmNotPaidSubsciptionLastSixMonths(Map<String, Customer>customerMap) {
		Iterator<Customer> itr = customerMap.values().iterator();
		while(itr.hasNext()) {
			Customer customer = itr.next();
			if(Period.between(customer.getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths() > 6)
				itr.remove();
		}
	}
	
	public static void sortByDobRegAmount(Map<String, Customer> customerMap) {
		customerMap.values()
		.stream()
		.sorted(
				(c1,c2) -> 
				{
					int cmp = c1.getDob().compareTo(c2.getDob());
					if(cmp == 0)  
						return ((Double)c1.getRegAmt()).compareTo(c2.getRegAmt());
					return cmp;
				}
		)
		.forEach(customer -> System.out.println(customer));		
	}

	public static void sortByEmail(Map<String, Customer> customerMap) {
		customerMap.values()
		.stream()
		.sorted()
		.forEach(customer -> System.out.println(customer));		
	}
}
