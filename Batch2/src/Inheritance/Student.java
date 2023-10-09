package Inheritance;

public class Student extends Person{
	private int gradYear;
	private String enrolledCourse;
	private double fees;
	private float marks; //subject expertise
	
	public Student(String fnm, String lnm, int gradYear, String enrolledCourse, double fees, int marks) {
		// explicitly invoke MATCHING super class ctor
		super(fnm, lnm);
		System.out.println("Inside Student(sub class) ctor");
		this.gradYear = gradYear;
		this.enrolledCourse = enrolledCourse;
		this.fees = fees;
		this.marks = marks;
		//access super class data member
		//System.out.println(super.firstName);
		// can not access as it is private not visible outside class
	}
	public String getDetails() {
		return super.getDetails() +", Passing Year: "+ gradYear + ", Enrolled Course: " + enrolledCourse + ", Fees: " + fees + ", marks" + marks;
	}
}
