package string_handling;

public class TestString5 {

	public static void main(String[] args) {
		String s1="hello";
		String s2="hello";
		String s3=new String(s1);
		
		System.out.println(s1 == s3); //false
		
		String s4=s3.intern();
		
		System.out.println(s3 == s4); //false
		System.out.println(s1 == s4); //true
		
		String s9=new String(s1.toUpperCase());
        System.out.println(s9); //HELLO
		String s10=s9.intern(); 
		//JVM will check if HELLO is available in SCP
		//if yes then it returns add of that String object
		//otherwise it creates new one in SCP and returns add of new String object
        
        
		//concat vs + operator
		String s5="he"+"llo";
		String s6="he".concat("llo"); 
		
		System.out.println(s1==s2); //true
		System.out.println(s1==s3); //false
		System.out.println(s1==s4); //true
		System.out.println(s1==s5); //true
		System.out.println(s1==s6); //false
		System.out.println(s3==s6); //false

		String s11="HELLO";
		System.out.println(s10==s11); //true

	}

}
