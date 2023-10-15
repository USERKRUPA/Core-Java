/*4.1 Display food menu to user. User will select items from menu along with the quantity. (eg 1. Dosa 2. Samosa 3. Idli ... 10 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
When user enters 'Generate Bill' option(10) , display total bill & exit.*/


import java.util.*;
class FoodMenu{

	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		boolean done = true;
		double tot_price = 0;
		int quantity;
		do{
			System.out.println("\n =========WELCOME TO KRUPA SAKSHI KITCHEN========\n ::Food Menu:: \n 1.Dosa(20)\n 2.Samosa(10)\n 3.Idli(25)\n 4.Poha(20)\n 5.Uttapam(30)\n 6.Upma(25)\n 7.Vadapav(10)\n 8.Misal(50)\n 9.Dhokla(15)\n 10.Generate bill");
			System.out.println("Enter Your Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter quantity for Dosa...");
					quantity = sc.nextInt();
					tot_price += 20 * quantity;
					break;
				case 2:	
					System.out.println("Enter quantity for Samosa...");
					quantity = sc.nextInt();			
					tot_price += 10 * quantity;
					break;
				case 3:
					System.out.println("Enter quantity for Idli...");
					quantity = sc.nextInt();
					tot_price += 25 * quantity;
					break;
				case 4:
					System.out.println("Enter quantity for Poha...");
					quantity = sc.nextInt();
					tot_price += 20 * quantity;
					break;
				case 5:
					System.out.println("Enter quantity for Uttampam...");
					quantity = sc.nextInt();
					tot_price += 30 * quantity;
					break;
				case 6:
					System.out.println("Enter quantity for Upma...");
					quantity = sc.nextInt();
					tot_price += 25 * quantity;
					break;
				case 7:
					System.out.println("Enter quantity for Vadapav...");
					quantity = sc.nextInt();
					tot_price += 10 * quantity;
					break;
				case 8:
					System.out.println("Enter quantity for Misal...");
					quantity = sc.nextInt();
					tot_price += 50 * quantity;
					break;
				case 9:
					System.out.println("Enter quantity for Dhokla...");
					quantity = sc.nextInt();
					tot_price += 15 * quantity;
					break;
				case 10:
					System.out.println("Total Bill is: "+ tot_price);
					done = false;
					break;
				default:
					System.out.println("Invalid Choice...");
			}
		}while(done);		
		sc.close();
        }
}