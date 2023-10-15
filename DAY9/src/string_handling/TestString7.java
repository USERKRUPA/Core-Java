package string_handling;

public class TestString7 {
	public static void main(String... args) {
		String s1 = new String("testing strings");
		String s2 = new String("testing strings");
		String s3 = new String("Testing Strings");
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		System.out.println(s1 == s3); // false
		System.out.println(s1.equals(s3)); // false
		System.out.println(s1.equalsIgnoreCase(s3)); // true
	}
}
