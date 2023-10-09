package Inheritance;

public class Faculty extends Person{
	private int expYear;
	private String se; //subject expertise
	
	public Faculty(String fnm, String lnm, int year, String se) {
		super(fnm, lnm);
		System.out.println("Inside Faculty(sub class) ctor");
		expYear = year;
		this.se = se;
	}
	public String getDetails() {
		return super.getDetails() +", Year of Exp: "+ expYear + ", Subject of expetise: " + se;
	}
}
