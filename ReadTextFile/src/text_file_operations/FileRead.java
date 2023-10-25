package text_file_operations;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.app.core.Transaction;

public class FileRead {
	/*
	 * Display following details on the console: Sum of all deposits Max deposit
	 * amount Shopping expenses (sum of withdrawals for shopping) Date on which
	 * maximum amount withdrawn
	 */

	public static void main(String[] args) {
		try (BufferedReader brd = new BufferedReader(new FileReader("F:\\KRUPA\\CDAC_PG-DAC\\JAVA\\CODE\\Jan2023.txt"));
			/*	Scanner read = new Scanner(brd)*/) {
			List<Transaction> txList = new ArrayList<Transaction>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println( brd.readLine());
			//read.useDelimiter(",");
			String str = null;
			while ((str= brd.readLine()) != null) {
				String data[] = str.split(",");
				Date date = (Date) (sdf.parse(data[0]));
				double wdrawlAmt = Double.parseDouble(data[2]);
				double dpstAmt = Double.parseDouble(data[3]);
				
				System.out.print(data[0] + " " + data[1] + " "+ wdrawlAmt + " "+ dpstAmt+ "\n");
				txList.add(new Transaction(date, data[1], wdrawlAmt, dpstAmt));
			}
			// TransactionDate,Narration,WithdrawalAmount,DepositAmount
			System.out.print("1. Sum of all deposits: ");
			double sum = txList.stream()
					.mapToDouble(tx -> tx.getDpstAmt())
					.sum();
			System.out.println(sum);

			System.out.print("2. Max deposit amount: ");
			double max = txList.stream()
			.max((t1, t2) -> (int)(t1.getDpstAmt()-t2.getDpstAmt()))
			.map(t -> t.getDpstAmt())
			.get();
			System.out.println(max);
			
			System.out.print("3. Shopping expenses (sum of withdrawals for shopping): ");
			sum = txList.stream()
					.filter(tx -> tx.getNarrat().equalsIgnoreCase("shopping"))
					.mapToDouble(tx -> tx.getWdrawlAmt())
					.sum();
			System.out.println(sum);
			
			System.out.print("4. Date on which maximum amount withdrawn: ");
			Date d = txList.stream()
			.max((t1,t2)-> (int)(t1.getWdrawlAmt()-t2.getWdrawlAmt()))
			.map(t -> t.getTxDate())
			.get();
			System.out.println(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
