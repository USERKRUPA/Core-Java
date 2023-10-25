package utils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Stock;

public interface IOUtils {
	@SuppressWarnings("resource")
	static void storeStockDetails(Map<String, Stock> stockMap, String fileName) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(stockMap);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
