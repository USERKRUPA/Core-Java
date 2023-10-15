/*
Create java application for the following Accept 2 numbers from user & operation to perform 1. Add 2.Subtract 3. Multiply 4.Divide 5.Exit Display the result of the operation. 
Java app must continue to run till user chooses exit option.
*/

import java.util.*;
class Calculator{
	public static void main(String[]args){

		Scanner sc = new Scanner(System.in);
		boolean done = true;

		do{
			System.out.println("\n =========CALCULATOR========\n 1. Addition \n 2. Subtraction\n 3. Multiply\n 4. Divide\n 5. Modulo \n 6. Exit");
			System.out.println("Enter Your Choice: ");
			int choice =sc.nextInt();			

			System.out.println("Enter two numbers: ");
			int no1 = sc.nextInt();
			int no2 = sc.nextInt();

			switch(choice){
				case 1:
					System.out.println("Addition of two numbers : "+ (no1 + no2));
					break;		
				case 2:
					System.out.println("Subtraction of two numbers : "+ (no1 - no2));
					break;	
				case 3:
					System.out.println("Multiplication of two numbers : "+ (no1 * no2));
					break;	
				case 4:
					System.out.println("Division of two numbers : "+ (no1 / no2));
					break;	
				case 5:
					System.out.println("Modulo of two numbers : "+ (no1 % no2));
					break;			
				case 6: 
					done = false;
					break;	
				default:
					System.out.println("Invalid Choice...");
			}
		}while(done);		
		sc.close();
        }
}