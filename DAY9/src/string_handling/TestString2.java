package string_handling;

public class TestString2 {

	public static void main(String[] args) {
		byte[] b = {'1', '2', '3', '4'};
		//String (byte[] bytes,int offset,int len)
		String s1 = new String(b, 2, 2);  
		System.out.println("s1 = " + s1); // s1.toString(): o/p is 22
		System.out.println("class with hashcode(s1):"+ s1.hashCode());
		
		
		char[] charr = {'k','r','u','p','a'};
		//String(char[] ch,int offset,int len)
		//String s2 = new String(charr, 1, 5); 
		//in above line no javac error, Java runtime error
		String s2 = new String(charr, 1, 4);
		System.out.println("s2 = " + s2);
		System.out.println("class with hashcode(charr):"+ charr);
		
		String s3 = new String(s1);
		System.out.println(s3);
		System.out.println("Class name(s3): " + s3.getClass());
		System.out.println("hashcode(s3): "+ s3.hashCode());
		System.out.printf("hashcode(s3) in hex format: %h%n", s3.hashCode() );
		
	}

}
