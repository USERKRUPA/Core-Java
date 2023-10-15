package string_handling;

public class TestString4 {
	
	public static void main(String[] args) {

		String str = "hello";
		// concat():
		str.concat(" world"); // do not modify str
		System.out.println(str);
		str = str.concat(" world"); // modified literal add will be stored in ref str
		System.out.println(str);

		// concat vs + operator
		String s1 = "hello ".concat("world");
		System.out.println(s1);
		String s2 = "hello" + "world";
		System.out.println(s2);
	}
}
