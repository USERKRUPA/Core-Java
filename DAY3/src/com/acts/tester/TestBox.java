package com.acts.tester;
import com.acts.code.Box;
  
import java.util.*;
class TestBox{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		Box b1 = new Box();
		System.out.println(b1.getBoxDetails());

		Box oldBox = new Box(sc.nextDouble() , sc.nextDouble() , sc.nextDouble());
		System.out.println(oldBox.getBoxDetails());
		System.out.println(oldBox.getBoxVolume());

		Box b2 = new Box(1,2,3);
		System.out.println(b2.getBoxDetails());
		System.out.println(b2.getBoxVolume());
		if(b1.isEqual(b2))
			System.out.println("Same");
		else
			System.out.println("Different");
		
		System.out.println("Enter three offesets for new box");
		Box b3 = oldBox.modifiedBox(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		System.out.println(b3.getBoxDetails());
		sc.close();
	}
}