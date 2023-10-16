package DateHandling;

import java.time.LocalDate;
import java.util.*;
public class TestDate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			LocalDate date = LocalDate.now(); // now() is static method of LocalDate
			// returns today's date
			System.out.println("Today's date is: " + date);
			System.out.println("enter your birthdate(yyyy-MM-dd): ");
			LocalDate birthDate = LocalDate.parse(sc.next());
			System.out.println("Entered date is: "+ birthDate);
			System.out.println(date.isBefore(birthDate)); 
			System.out.println(date.isAfter(birthDate));
			System.out.println("age is: " + (date.getYear()-birthDate.getYear()));
		}
		//parse() method throws DateTimeParseException and DateTimeException
		// Both are unchecked exception
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
