package tester;

import java.util.*;

import javax.security.sasl.AuthenticationException;

import com.app.core.Order;
import com.app.core.Pet;

import exception_handling.AuthorizationException;

import static utils.PetUtils.*;
import static utils.UserUtils.*;
import static utils.OrderUtils.*;

public class PetStoreTester {
	/*
	 * Admin User (loginId=admin, password = admin) Customer (loginId=c1,
	 * password=c1) Accessing Admin only functionality by customer will throw
	 * Unauthorized exception
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean flag = true;
			String userid = null;
			boolean isLogin = false;
			Map<Integer, Pet> petMap = new HashMap<>();
			Map<Integer, Order> orderMap = new HashMap<>();
			while (flag) {
				try {
					System.out.println("1. Login \n2. Add new Pet (Admin only functionality)"
							+ "\n3. Update Pet details (Admin only functionality)" + "\n4. Display all available pets"
							+ "\n5. Order a Pet" + "\n6. Check order status by Order Id "
							+ "\n7. Update order status (Admin only functionality) " + "\n0. Exit");
					System.out.println("Enter your choice: ");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter login id and password:");
						userid = sc.next();
						authenticateUser(userid, sc.next());
						System.out.println("Welcome, " + userid);
						isLogin = true;
						break;
					case 2:
						Pet pet = null;
						if (!isLogin)
							throw new AuthenticationException("Login is mandataory...");
						if (!userid.equals("admin"))
							throw new AuthorizationException("Unauthoried user");
						System.out.println("Enter petId,  name,  category,  unitPrice,  stocks ");
						pet = validatePetDetails(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(),
								petMap);
						petMap.put(pet.getPetId(), pet);
						System.out.println("Pet is added");
						break;
					case 3:
						if (!isLogin)
							throw new AuthenticationException("Login is mandataory...");
						if (!userid.equals("admin"))
							throw new AuthorizationException("Unauthoried user");
						System.out.println("Enter petId ,  name,  category,  unitPrice,  stocks ");
						updatePetDetails(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), petMap);
						System.out.println("Details updated....");
						break;
					case 4:
						if (!isLogin)
							throw new AuthenticationException("Login is mandataory...");
						petMap.forEach((id, p) -> System.out.println(p));
						break;
					case 5:
						if (!isLogin)
							throw new AuthenticationException("Login is mandataory...");
						System.out.println("Enter petid and quantity to order:");
						Order orderNew = orderPet(sc.nextInt(), sc.nextInt(), petMap);
						orderMap.put(orderNew.getOrderId(), orderNew);
						System.out.println("Your Order has been placed...\nOrder id is: " + orderNew.getOrderId());
						break;
					case 6:
						if (!isLogin)
							throw new AuthenticationException("Login is mandataory...");
						System.out.println("Enter order id to check status:");
						orderMap.values().stream().filter(ord -> ((Integer) ord.getOrderId()).equals(sc.nextInt()))
								.map(ord -> ord.getStatus()).forEach(System.out::println);
						break;
					case 7:
						if (!isLogin)
							throw new AuthenticationException("Login is mandataory...");
						if (!userid.equals("admin")) {
							throw new AuthorizationException("Unauthorized user");
						}
						System.out.println("Enter order id and status");
						updateOrderStatus(sc.nextInt(), sc.next(), orderMap);
						System.out.println("Order status updated..");
						break;
					case 0:
						flag = false;
						break;
					default:
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}
}
