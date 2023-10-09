package Tester;

import java.util.Scanner;

import com.acts.code.Box;

public class TestBoxArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give number of Boxes u want: ");
		Box []boxes = new Box[sc.nextInt()];
		for(int i = 0; i < boxes.length; i++) {
			System.out.println("Enter Dimension for Box: ");
			 boxes[i]= new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());			
		}
		for(Box b : boxes) {
			System.out.println(b.getBoxDetails());
			System.out.println(b.getBoxVolume());
			if(b.getBoxVolume() > 100) {
				b.setWidth(b.getWidth() * 2);
			}
		}
		System.out.println("Box Details after Update: ");
		for(Box b : boxes) {
			System.out.println(b.getBoxDetails());
		}
		//after this, how many objects marked for GC ? 0
		
		//boxes=null;
		//after above line,
		//how many objects marked for GC ? 5 (array + 4 boxes)
		
		sc.close();
	}
}
