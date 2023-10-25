package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import com.app.core.Brand;
import com.app.core.Color;
import com.app.core.Material;
import com.app.core.Pen;

import pen_exception_handling.StylishPenException;

public interface PenComparator {
	
	static void print(List<Pen> penList) {
		for(Pen p : penList)
			System.out.println(p);
	}
	static ArrayList<Pen> populateList() {
		ArrayList<Pen> penList = new ArrayList<>();
		//brand, Color color, Color inkColor, Material material, int stock, LocalDate listingDate,
		//double price, int discount
		penList.add(new Pen(Brand.CELLO, Color.BLACK, Color.BLUE, Material.ALLOYSTEEL, 50, LocalDate.parse("2023-04-22"), 120, 0));
		penList.add(new Pen(Brand.LINC, Color.BLUE, Color.BLUE, Material.PLASTIC, 200, LocalDate.parse("2022-04-24"), 10, 0));
		return penList;
	}
	static void checkDupBrand(Brand brand, List<Pen> penList) throws StylishPenException {
		Pen pen = new Pen(brand);
		if(penList.contains(pen))
			throw new StylishPenException("Duplicate Brand entry...");
		System.out.println("No duplication");
	}
	static Pen validateInputs(String brand, String color, String inkColor, String material, int stock, String updateDate,
			double price, int discount, List<Pen> penList) throws StylishPenException{
		Brand parsedBrand = parseAndValidateBrand(brand);
		checkDupBrand(parsedBrand, penList);
		Color parsedColor = parseAndValidateColor(color);
		Color parsedInkColor = parseAndValidateColor(inkColor);
		Material parsedMaterial = parseAndValidateMaterial(material);
		LocalDate parsedDate = parseDate(updateDate);
		return new Pen(parsedBrand, parsedColor, parsedInkColor, parsedMaterial, stock, parsedDate, price, discount);
	}
	static LocalDate parseDate(String updateDate) {
		return LocalDate.parse(updateDate);
	}
	static Material parseAndValidateMaterial(String material)  throws IllegalArgumentException{
		return Material.valueOf(material.toUpperCase());
	}
	static Color parseAndValidateColor(String color)  throws IllegalArgumentException{
		return Color.valueOf(color.toUpperCase());
	}
	static Brand parseAndValidateBrand(String brand) throws IllegalArgumentException{
		return Brand.valueOf(brand.toUpperCase());
	}
	static void updateStock(String brand, int stock, List<Pen> penList) {
		Brand parsedBrand = parseAndValidateBrand(brand);
		for(Pen p : penList){
			if(p.getBrand() == parsedBrand) {
				p.setStock(stock);
				p.setUpdateDate(LocalDate.now());;
			}
		}
		System.out.println("Stock has been updated...");
	}
	static void removeNotSoldPens(List<Pen> penList) {
		int counter = 0;
		Iterator<Pen> itr = penList.iterator();
		while(itr.hasNext()) {
			Pen p = itr.next();
			if(Period.between( p.getListingDate(),p.getUpdateDate()).toTotalMonths() > 9) {
				itr.remove();
				counter++;
			}
		}
		if(counter > 0)
			System.out.println("Pens are removed...");
		else
			System.out.println("No such pens are available...");
	}
}
