package string_handling;

import java.util.Date;

public class TestStringBuilder {

	public static void main(String[] args) {
		//StringBuilder objects are mutable that is modifiable
		// inits a new SB with specified string , n allocates 16 chars
		StringBuilder sb1 = new StringBuilder("testing");
		System.out.println(sb1);// testing //sb1.toString()
		System.out.println("len= " + sb1.length() + " capa " + sb1.capacity());// 7 23
		StringBuilder sb2 = sb1.append(false); 
		System.out.println(sb1); //testingfalse
		System.out.println(sb2); //testingfalse
		System.out.println(sb1 == sb2); //false
		
		// method chaining
		sb2 = sb1.append('c').append(123.45).append(34.567f).append(new Date());
		System.out.println(sb2);
		//o/p: testingfalsec123.4534.567+current date
		System.out.println(sb1);
		//o/p: testingfalsec123.4534.567+current date
		
		char[] chars = { 'a', 'b', 'c' };
		//	insert​(int index, char[] str, int offset, int len)
		sb1.insert(0, chars, 1, 2);
		System.out.println(sb1); 
		//o/p: bctestingfalsec123.4534.567+current date
		
		System.out.println(sb1.length() + " " + sb1.capacity());
		
		sb1.delete(0, 6); //removes characters from index 0 to index 6-1(5) within sb1 
		System.out.println("sb contents: " + sb1);
		
		sb1.delete(0, sb1.length()); //removes characters from index 0 to length-1 (all characters) within sb1 
		System.out.println("sb contents: " + sb1);
		
		System.out.println(sb1.length() + " " + sb1.capacity());
		// length= size= 0 but capacity as it is
		
		sb1.trimToSize();// tries to reduce capa=length
		System.out.println(sb1.length() + " " + sb1.capacity());

	}

}
