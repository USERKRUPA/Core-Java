package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import com.app.core.Item;

public interface IOUtils {
	static void storeItemDetails(Map<String, Item> itemMap, String fileName) throws IOException {
		try{
			@SuppressWarnings("resource")
			ObjectOutputStream out_code = new ObjectOutputStream(
				new FileOutputStream(fileName));
		out_code.writeObject(itemMap);

		}
		catch(Exception e) {
			System.out.println("inside Collection Utils");
			e.printStackTrace();
		}
	}
	
	static void storeItemDetails2(List<Item> itemList, String fileName) throws IOException {
		try{
			@SuppressWarnings("resource")
			ObjectOutputStream out_code = new ObjectOutputStream(
				new FileOutputStream(fileName));
		out_code.writeObject(itemList);

		}
		catch(Exception e) {
			System.out.println("inside Collection Utils");
			e.printStackTrace();
		}
	}
	
/*	@SuppressWarnings("unchecked")
	static Map<String, Item> restoreItemDetails(
			String fileName) //throws IOException,ClassNotFoundException  
	{
		// chain of strms for de-ser
		// Java App <--- OIS <---- FIS <---- bin file
		try (ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(fileName))) {
			return (Map<String, Item>) in.readObject();//de ser
		} catch (Exception e) {
			e.printStackTrace();
			//=> de ser : failed , ret empty map
			return new HashMap<>();
		}

	}*/
}
