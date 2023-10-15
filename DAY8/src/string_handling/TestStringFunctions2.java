package string_handling;

import java.util.Arrays;

public class TestStringFunctions2 {
	//,,
	
	public static void main(String[] args) {
		String[] names= {"Anish","Smita","Shubham",
				"Sarita","Kiran","Amiti"};
		//display names sorted as asc (natural order)
		System.out.println("Names in asc order");
		//Internally JVM invokes stable sorting algo. , internally calling 
		//String's compareTo method
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		
		
	}

}
