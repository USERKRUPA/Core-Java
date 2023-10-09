package Inheritance;

public class Person {
	private String firstName;
	private String lastName;
	public Person(String fnm, String lnm) {
		System.out.println("Inside Person(Super class) Ctor: ");
		firstName = fnm;
		lastName = lnm;
	}
	public String getDetails() {
		return "Name: "+ firstName + " " + lastName;
	}
}
