package customer_stack;

import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		boolean flag = false;
	
		Stack s = null;
		while(!flag) {
			System.out.println("\n1. Fixed Stack\n2. Growable stack\n3. Push\n4. Pop\n5. Exit");
			System.out.println("Enter your choice:");
			switch(sc.nextInt()) {
			case 1:
				if(s == null) {
					System.out.println("Fixed Stack chosen....");
					s = new FixedStack();
				}
				else
					System.out.println("Stack already chosen....");
				//	throw new StackException("Stack already choosen...");*/
				break;
			case 2:
				if(s == null) {
					System.out.println("Growable Stack chosen....");
					s = new GrowableStack();	
				}
				else
					System.out.println("Stack already chosen....");
				//	throw new StackException("Stack already choosen...");*/
				break;
			case 3:
				if(s != null) {
					System.out.println("Enter cutomer detail(id, name, address");
					s.push(new Customer(sc.nextInt(), sc.next(), sc.next()));
				}
				else {
					throw new StackException("No stack choosen...");
				}
				break;
			case 4:
				if(s != null) {
					//Customer cust = s.pop();
					System.out.println(s.pop());
				}
				else {
					throw new StackException("No stack choosen...");
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
		catch(StackException e) {
			System.out.println(e.getMessage());
		}
	}

}
