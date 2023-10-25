package tester;

import java.io.*;
import java.util.*;

import com.app.core.Item;
import static utils.CollectionUtils.*;
import static utils.IOUtils.*;
public class ItemTester {

	/*
	 *
	 * 
	 * Sort these details as per Item code. Store them in binary file using
	 * serialization technique, before terminating from application.(file name :
	 * items_code.ser)
	 * 
	 * Sort these details as per Item price. Store them in binary file using
	 * serialization technique, before terminating from application
	 * 
	 * Note : Use Scanner to accept details from user.
	 */

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Item> itemMap = populateMap(sc);
			System.out.println("Before sort");
			itemMap.forEach((k,v)-> System.out.println(v));
			//sort by itemcode
			TreeMap<String, Item> itemTreeMap = new TreeMap<String, Item>(itemMap);
			System.out.println("\nAfter sort");
			itemTreeMap.forEach((k,v)-> System.out.println(v));
			System.out.println("Enter file name:");
			storeItemDetails(itemTreeMap, sc.nextLine());		
			
			//sort by item price
			//can not be solved by converting hashmap to treemap
			//so convert from hashmap to collection
			ArrayList<Item> arrList = new ArrayList<>(itemMap.values());
			Comparator<Item> comparator = (i1, i2) -> i1.getShipmentDate().compareTo(i2.getShipmentDate()); 
			Collections.sort(arrList, comparator);
			System.out.println("Enter file name:");
			storeItemDetails2(arrList, sc.nextLine());
			System.out.println("Data stored infiles");
			/*System.out.println("Enter File name:");
			Map<String, Item> itemRestoreMap = restoreItemDetails(sc.nextLine());
			itemRestoreMap.forEach((k,v) -> System.out.println(v));*/
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
