package tester;

import java.io.*;
import java.util.*;

import com.app.core.Stock;

import custom_exceptions.StockHandlerException;

import static utils.CollectionUtils.*;
import static utils.IOUtils.*;
import static utils.ValidationRules.*;

public class StockTradingService {

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			boolean flag = true;
			Map<String, Stock> stockMap = populateStockMap();

			while (flag) {
				try {
					System.out.println("1. Add New stock in the market" + "\n2. View Available stocks by Company"
							+ "\n3. Purchase stocks" + "\n4. Sell Stocks" + "\n0. Save n Exit :");
					System.out.println("Enter your choice:");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter stock id, stock name, company name, price, closing date, quantity ");
						Stock stock = validateAllInputs(sc.next(), sc.next(), sc.next(),sc.nextDouble(),sc.next(), sc.nextInt(), stockMap);
						stockMap.put(stock.getStockId(), stock);
						break;
					case 2:
						//i/p : company name;
						System.out.println("Enter company name: ");
						String cmp = sc.next();
						//System.out.println("Company Stock Market Details:");
						stockMap.values().stream()
						.filter(st ->st.getCmpnyName().equals(cmp))
						.forEach(System.out::println);
						//error should be displayed if company doesn't exists
						break;
					case 3:
						//input : stock id , quantity
						System.out.println("Enter stock id and quantity");
						purchaseStock(sc.next(), sc.nextInt(), stockMap);
						System.out.println("Stock has been purchased");
						break;
					case 4:
						//input : stock id , quantity
						System.out.println("Enter stock id and quantity");
						//sellStock(sc.next(), sc.nextInt(), stockMap);
						stockMap.values()
						.stream()
						.filter(st -> st.getStockId().equals(sc.next()))
						.forEach(st -> {
							try {
								sellStock(st, sc.nextInt());
							} catch (StockHandlerException e) {
								System.out.println(e.getMessage());
							}
						});
						System.out.println("Stock has been sold");
						break;
					case 0:
						System.out.println("Enter file Name:");
						storeStockDetails(stockMap,sc.nextLine());
						flag = false;
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}
	}

}
