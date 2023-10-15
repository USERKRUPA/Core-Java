package string_handling;

public class TestString1 {

	public static void main(String[] args) {
		byte[] b = {'1', '2', '3', '4'};
		String s1 = new String(b); 
		System.out.println(s1); // s1.toString()
		
		char[] charr = {'1', '2', '3', '4'};
		String s2 = new String(charr);
		System.out.println(s2);
		
		//check by reference: o/p is not equal
		if(s1 == s2) 
			System.out.println("equals");
		else
			System.out.println("not equal");
		
		//check by content: o/p is equal
		if(s1.equals(s2)) 
			System.out.println("equals");
		else
			System.out.println("not equal");
	}
}
