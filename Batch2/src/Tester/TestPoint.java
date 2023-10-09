package Tester;
import Point.Point2D;
import java.util.*;

class TestPoint{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of point array: ");
		Point2D p[] = new Point2D[sc.nextInt()];
		System.out.println("1. Plot a point\n2. Display all points\n3. Check equality and calculate distance\n0. Exit");
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		int flag = 0;
		switch(choice) {
			case 0:
					System.exit(0);
			case 1:
					System.out.println("Enter array index to insert: ");
					int i = sc.nextInt();
					double x = sc.nextDouble();
					double y = sc.nextDouble();
					if(i > p.length) {
						System.out.println("Index can not be accessible...");
					}
					for(Point2D point : p) {
						flag = point.search(x, y) ? 1 : 0;	
						if(flag == 1)
							break;
					}						
					break;
			case 2:
			case 3:
		}
		sc.close();
		
	}
	
}