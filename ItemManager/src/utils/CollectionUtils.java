package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.*;

import com.app.core.Item;

public interface CollectionUtils {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	static Map<String, Item> populateMap(Scanner sc) throws ParseException{
		HashMap<String, Item> itemMap = new HashMap<>();
		int counter = 0;
		while(counter++ < 3) {
			System.out.println("Enter itemCode,  desc,  price,  shipmentDate(dd-MM-yyyy)");
			Item item = addItemToMap(sc.next(), sc.next(), sc.nextDouble(), sc.next(), itemMap);
			itemMap.put(item.getItemCode(), item);
		}
		//sc.close();
		sc.nextLine();
		return itemMap;
	}
	
	 static Item addItemToMap(String itemCode, String desc, double price, String shipmentDate,
			Map<String, Item> itemMap) throws ParseException{
		Date parsedShipmentDate = sdf.parse(shipmentDate);
		return new Item(itemCode, desc, price, parsedShipmentDate);
	}
}
