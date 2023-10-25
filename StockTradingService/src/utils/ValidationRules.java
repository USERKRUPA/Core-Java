package utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Stock;

import custom_exceptions.StockHandlerException;

public interface ValidationRules {
	//Ensure no duplicate stock ids. 
	//Add a validation rule that stock closing date must be a future date.
	static Stock validateAllInputs(String stockId, String stockName, String cmpnyName, double price, String closingDate,
			int quantity, Map<String, Stock> stockMap) throws StockHandlerException {
		chkDupStock(stockId, stockMap);	
		LocalDate parsedClosingDate = parseAndValidateDate(closingDate);
		if(quantity <= 0)
			throw new StockHandlerException("quantity value must be positive:");
		return new Stock(stockId, stockName, cmpnyName,price, parsedClosingDate,quantity); 
	}

	static LocalDate parseAndValidateDate(String closingDate) throws StockHandlerException {
		LocalDate parsedDate = LocalDate.parse(closingDate);
		if(parsedDate.isBefore(LocalDate.now()))
			throw new StockHandlerException("Closing date must be a future date");
		return parsedDate;
	}

	static void chkDupStock(String stockId, Map<String, Stock> stockMap) throws StockHandlerException {
		if(stockMap.containsKey(stockId)) 
			throw new StockHandlerException("Stock entry already exists");
	}
}
