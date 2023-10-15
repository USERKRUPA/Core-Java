package string_handling;

public class TestString6 {
	public static void main(String ... args) {
		String s="Hello";
		s.toUpperCase(); 
		s.concat("12345"); 
		System.out.println(s);  // Hello
		String s1="testing strings";
		String s2=new String(s1);
		System.out.println(s1==s2); //false
		System.out.println(s1.equals(s2)); //true
		String s3="He"+"llo"; 
		String s4="He".concat("llo");
		String s5="hello";
		String s6="he";
		String s7="llo";
		String s8 = s6 + s7;
		System.out.println(s==s3); //true
		System.out.println(s==s4); //false
		System.out.println(s==s5); //false
		System.out.println(s5==s8); //false
	}
}
