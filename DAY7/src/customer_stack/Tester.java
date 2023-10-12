package customer_stack;

import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		boolean flag = false;
		boolean mutex = false;
		Stack s = null;
		while(!flag) {
			System.out.println("\n1. Fixed Stack\n2. Growable stack\n3. Push\n4. Pop\n5. Exit");
			System.out.println("Enter your choice:");
			switch(sc.nextInt()) {
			case 1:
				if(!mutex) {
					s = new FixedStack();
					mutex = true;
					System.out.println("You can perform operation on Fixed Stack....");
				}
				break;
			case 2:
				if(!mutex) {
					s = new GrowableStack();
					mutex = true;
					System.out.println("You can perform operation on Growable Stack....");
				}
				break;
			case 3:
				if(mutex) {
					System.out.println("Enter cutomer detail(id, name, address");
					s.push(new Customer(sc.nextInt(), sc.next(), sc.next()));
				}
				else {
					System.out.println("No stack choosen...");
				}
				break;
			case 4:
				if(mutex) {
					//Customer cust = s.pop();
					System.out.println(s.pop().toString());
				}
				else {
					System.out.println("No stack choosen...");
				}
				break;
			case 5:
				flag = true;
				break;
			default:
				System.out.println("Enter valid choice...");
			}
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
