package utils;

import java.time.LocalDate;
import java.util.*;

import com.app.core.Stock;

import custom_exceptions.StockHandlerException;

public interface CollectionUtils {
	static Map<String, Stock> populateStockMap() {
		HashMap<String, Stock> stockMap = new HashMap<>();
		// String stockId, String stockName, String cmpnyName, double price, Date
		// closingDate, int quantity
		stockMap.put("s1", new Stock("s1", "Bajaj finserv", "Bajaj", 100.0, LocalDate.parse("2023-11-02"), 100));
		stockMap.put("s12", new Stock("s12", "TCS", "Tata", 190.0, LocalDate.parse("2023-12-02"), 150));
		stockMap.put("s5", new Stock("s5", "HDFC aliance", "HDFC", 253.0, LocalDate.parse("2024-01-02"), 1000));
		stockMap.put("s7", new Stock("s7", "ICICI prudential", "ICICI", 525.0, LocalDate.parse("2023-12-22"), 500));
		stockMap.put("s10", new Stock("s10", "Nirma finance", "Nirma", 608.20, LocalDate.parse("2023-11-18"), 1500));

		return stockMap;
	}

	static void purchaseStock(String stockId, int quantity, Map<String, Stock> stockMap) throws StockHandlerException {
		if (!stockMap.containsKey(stockId))
			throw new StockHandlerException("Invalid stock id");
		Stock stock = stockMap.get(stockId);
		int availableQty = stock.getQuantity();
		if (quantity <= 0)
			throw new StockHandlerException("Quatity must be positive");
		if (quantity > availableQty)
			throw new StockHandlerException("Insufficient quantity");
		stock.setQuantity(stock.getQuantity() - quantity);
		
	}
	
	static Stock sellStock(Stock st, int quantity) throws StockHandlerException {
		if (quantity <= 0)
			throw new StockHandlerException("Quatity must be positive");
		if (quantity > st.getQuantity())
			throw new StockHandlerException("Insufficient quantity");
		st.setQuantity(st.getQuantity() + quantity);
		return st;
	}
}
