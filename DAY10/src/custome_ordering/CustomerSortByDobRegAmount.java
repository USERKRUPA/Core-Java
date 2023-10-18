package custome_ordering;

import java.util.Comparator;
import customermgmtsystem.com.app.core.Customer;

public class CustomerSortByDobRegAmount implements Comparator<Customer> {

	@Override
	public int compare(Customer cust1, Customer cust2) {
		int i = cust1.getDob().compareTo(cust2.getDob());
		if (i == 0) {
			if (cust1.getRegAmount() > cust2.getRegAmount())
				return 1;
			if (cust1.getRegAmount() < cust2.getRegAmount())
				return -1;
		}
		return i;
	}
}
