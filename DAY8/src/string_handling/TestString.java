package string_handling;

public class TestString {
	public static void main(String... args) {
		// string ref are immutable
		String s = "hello";
		s.concat("hi");
		System.out.println(s);// hello
		s += " 12345";// s=s+"12345"
		System.out.println(s);// hello 12345
		System.out.println("string len: " + s.length()); // 11
		
		String s1 = "hello 12345";
		System.out.println(s);// hello12345
		System.out.println(s.intern() == s1); // true
		System.out.println(s == s1); // false
		
		String s3 = "hello " + "12345";
		System.out.println(s1 == s3); // true
		System.out.println(s == s3); // false
	}
}
