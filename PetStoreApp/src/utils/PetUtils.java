package utils;

import java.util.Map;

import com.app.core.Category;
import com.app.core.Pet;

import exception_handling.PetException;

public interface PetUtils {
	static Pet validatePetDetails(int petId, String name, String category, int unitPrice, int stocks,
			Map<Integer, Pet> petMap) throws PetException, IllegalArgumentException{
		chkDupPetId(petId, petMap);
		Category parsedCategory = Category.valueOf(category.toUpperCase());
		return new Pet(petId, name, parsedCategory, unitPrice, stocks);
	}

	static void chkDupPetId(int petId, Map<Integer, Pet> petMap) throws PetException {
		if(petMap.containsKey(petId))
			throw new PetException("Duplicate Pet Id entered");
	}
	static void updatePetDetails(int petId, String name, String category, int unitPrice, int stocks,
			Map<Integer, Pet> petMap) throws PetException {
		Pet pet = petMap.get(petId);
		if(pet == null)
			throw new PetException("No such Pet Exists...");
		Category parsedCategory = Category.valueOf(category.toUpperCase());
		pet.setName(name);
		pet.setCategory(parsedCategory);
		pet.setUnitPrice(unitPrice);
		pet.setStocks(stocks);
	}

}
