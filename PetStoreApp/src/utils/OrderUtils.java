package utils;

import java.util.Map;

import com.app.core.Order;
import com.app.core.Pet;
import com.app.core.Status;

import exception_handling.OutOfStockException;
import exception_handling.PetOrderException;

public interface OrderUtils {
	static void updateOrderStatus(int orderId, String status, Map<Integer, Order> orderMap) throws PetOrderException {
		Order ord = orderMap.get(orderId);
		if (ord == null)
			throw new PetOrderException("Invalid order id");
		ord.setStatus(Status.valueOf(status.toUpperCase()));
	}

	static Order orderPet(int petId, int quantity, Map<Integer, Pet> petMap)
			throws OutOfStockException, PetOrderException {
		if(quantity == 0)
			throw new PetOrderException("To place order, quantity shd be greater than 0...");
		Pet pet = petMap.get(petId);
		int stocks = pet.getStocks();
		if (stocks == 0)
			throw new OutOfStockException("Pet is out of stock");
		if (stocks < quantity)
			throw new OutOfStockException("Only " + stocks + " quantities are available");
		pet.setStocks(pet.getStocks() - quantity);
		return new Order(petId, quantity, Status.valueOf("PLACED".toUpperCase()));
	}
}
