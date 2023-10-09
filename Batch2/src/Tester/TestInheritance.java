package Tester;

import Inheritance.*;

public class TestInheritance {
	public static void main(String[] a) {
		//sub class ref --> sub class obj(DIRECT referencing)
		//String fnm, String lnm, int gradYear, String enrolledCourse, double fees, int marks
		Student s = new Student("Krupa","Thumar",2012, "DAC", 100000, 98);
		
		//DIRECT referencing
		//String fnm, String lnm, int year, String se
		Faculty f = new Faculty("David","Reddy", 5, "C C++ DS");
		//System.out.println(s.getDetails()); //calls student getDetails()
		//System.out.println(f.getDetails()); //calls faculty getDetails()
		
		Person p;
		p = s; //up casting 
		//up casting is done by javac compiler by seeing extends keyword
		System.out.println(p.getDetails());
		//run time polymorphism : getDetails of Student will be invoked
		
		p = f;
		System.out.println(p.getDetails());
	}
}
