import java.util.*;
class TestBox{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		Box b1;
		
		b1 = new Box(sc.nextDouble() , sc.nextDouble() , sc.nextDouble());
		System.out.println(b1.getBoxDetails());
		System.out.println(b1.getBoxVolume());
		Box b2 = new Box(1,2,3);
		System.out.println(b2.getBoxDetails());
		System.out.println(b2.getBoxVolume());
		if(b1.isEqual(b2))
			System.out.println("Same");
		else
			System.out.println("Different");
		Box b3 = b2.modifiedBox();
		System.out.println(b3.getBoxDetails());
		sc.close();
	}
}