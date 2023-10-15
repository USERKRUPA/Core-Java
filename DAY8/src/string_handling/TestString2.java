package string_handling;

public class TestString2 {

	public static void main(String[] args) {
		 char data[] = {'a', 'b', 'c'};
	     String str = new String(data);
	     System.out.println("abc"); //abc
	     String cde = new String("cde");
	     System.out.println("abc" + cde); //abccde
	     String c = "abc".substring(2,3); //string from index 2 to index 3-1
	     String d = cde.substring(1, 3);
	     System.out.println(c);
	     System.out.println(d);
	}

}
