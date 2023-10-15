package string_handling;

public class TestString8 {

	public static void main(String[] args) {
		String s=new String("hello");
		String s1=s.concat(" abc !");
		System.out.println(s); //hello
		System.out.println(s1); //hello abc !
		s=s.concat("12345");	
		System.out.println(s); 	//hello12345
		System.out.println(s.toUpperCase()); //HELLO12345
		System.out.println(s);	//hello12345
		String s2=s.replace('l', 't'); 
		System.out.println(s); //hello12345
		System.out.println(s2); //hetto12345
 		//s.concat(3456); //javac error: argument is int

	}
}
