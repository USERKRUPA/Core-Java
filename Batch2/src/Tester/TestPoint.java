package Tester;

import Point.Point2D;
import java.util.*;

class TestPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of point array: ");
		Point2D p[] = new Point2D[sc.nextInt()];
		System.out.println("1. Plot a point\n2. Display all points\n3. Check equality and calculate distance\n0. Exit");
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		boolean flag = false;
		while (!flag) {
			switch (choice) {
			case 0:
				System.exit(0);
			case 1:
				System.out.println("Enter array index to insert: ");
				int i = sc.nextInt();
				if (i <= 0 && i > p.length) {
					System.out.println("Index can not be accessible...");
				}
				System.out.println("Enter coordinates: ");
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				if (p[i] != null) {
					p[i] = new Point2D(x, y);
					System.err.println("plotted point succcessfully.");
				}
				else {
					System.out.println("Already plotted...");
				}
				break;
			case 2:
				break;
			case 3:
				break;
			}

		}
		sc.close();

	}

}