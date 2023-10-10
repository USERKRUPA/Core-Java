package Tester;

import java.util.Scanner;
import com.app.fruits.*;

public class FruitBasket {

	public static void main(String[] args) {
		/*
		 * 4.10 Supply options 
		 * 1. Add Mango 
		 * 2. Add Orange 
		 * 3. Add Apple NOTE : You will be ALWAYS adding a fresh fruit in the basket , 
		 * in all of above options.
		 * 
		 * 4. Display names of all fruits in the basket.
		 * 
		 * 5. Display name,color,weight , taste of all fresh fruits , in the basket.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Basket size: ");
		Fruit[] basket = new Fruit[sc.nextInt()];
		int i = 0;
		boolean exit = false;
		while(!exit) {
			System.out.println("Choose 1. Mango\n2. Orange\n3. Apple\n4. Show Names\n5. Show Details\n6. Mark fruit stale\n7. Mark sour fruit stale\n8. Fruit specific functionality\n9. Exit");
			System.out.println("Enter choice: ");
			switch(sc.nextInt()) {
			
			case 1:
				System.out.println("Enter weight: ");
				basket[i++] = new Mango(sc.nextDouble(), true);
				break;
			case 2:
				System.out.println("Enter weight: ");
				basket[i++] = new Orange(sc.nextDouble(), true);
				break;
			case 3:
				System.out.println("Enter weight: ");
				basket[i++] = new Apple(sc.nextDouble(), true);
				break;
			case 4:
				for(Fruit f : basket)
					if(f != null)
						System.out.println(f.getName());
				break;
			case 5:
				for(Fruit f : basket)
					if(f != null && f.isFresh()) {
						System.out.print(f);
						System.out.println(" and taste is: " + f.taste());
					}
				break;
			case 6:
				System.out.println("Enter index to make fruit as stale: ");
				int j = sc.nextInt();
				if(j < 0  && j > i) {
					System.out.println("Invalid index");
				}
				else
					basket[j].setFresh(false);
				break;
			case 7:
				for(int k =0 ; k < i; k++) {
					if(basket[k].taste().equals("sour")) {
						basket[k].setFresh(false);
					}
				}
				break;
			case 8:
				System.out.println("Enter index to make fruit as stale: ");
				j = sc.nextInt();
				if(j < 0  && j > i) {
					System.out.println("Invalid index");
				}
				else {
					if(basket[j] instanceof Mango)
						((Mango)basket[j]).pulp();
					else if(basket[j] instanceof Orange)
						((Orange)basket[j]).juice();
					else
						((Apple)basket[j]).jam();
				}
				break;
			case 9:
				exit = true;
				break;
			}
		}
		sc.close();
	}

}
