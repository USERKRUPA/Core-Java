package enumeration;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Fuel types are: ");
			for(Fuel f : Fuel.values())
				System.out.println(f); //f.toString() called
			System.out.println("Enter Fuel Type: ");
			Fuel f = Fuel.valueOf(sc.next().toUpperCase());
			//valueOf() throws IllegalArgumentException
			System.out.println("Entered fuel is: " + f);
			f.setCost(f.getCost()+20);
			System.out.println("Updated fuel is: " + f.getCost());
 		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
