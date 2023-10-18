package customermgmtsystem.com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Customer implements Comparable<Customer>{
	/* PK(UID) : email
	 *	Will you need to override toString n equals ?
	 */
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private LocalDate lastSubscriptionPaidDate;
	
	private static int id; 
	static {
		id = 0;
	}
	
	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.customerId = ++id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.lastSubscriptionPaidDate = LocalDate.now();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Customer(String email) {
		super();
		this.email = email;
	}
	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}
	
	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}
	public ServicePlan getPlan() {
		return plan;
	}
	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}
	public LocalDate getDob() {
		return dob;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan
				+ ", lastSubscriptionPaidDate= "+ lastSubscriptionPaidDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			Customer other = (Customer) obj;
			return this.email.equals(other.email);
		}
		return false;
	}
	@Override
	public int compareTo(Customer anotherCustomer) {
		return anotherCustomer.email.compareTo(this.email);
	}
}
