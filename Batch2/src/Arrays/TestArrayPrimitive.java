package Arrays;

import java.util.Scanner;

//import static java.lang.System.*;
public class TestArrayPrimitive {

	public static void main(String[] args) {
		//Array of primitive type
		System.out.println("Enter size of array:");
		Scanner sc = new Scanner(System.in);
		float array[] = new float[sc.nextInt()];
		System.out.println(array);//NameOfClass@hashCode : address
		System.out.println("class loaded for float[] "
		+array.getClass());
		
		for(float f : array)
			System.out.println(f);
		for(int i = 0; i < array.length; i++) {
			System.out.print("array["+i+"]: ");
			array[i] = sc.nextFloat();
		}
		System.out.println("Initiated Data:");
		for(float f : array)
			System.out.println(f);
		
		for(float f : array) {
			f *= 2;//doubling the copy of the array elem.	
		}
		//actual data is not going to be changed....
		System.out.println("Inited array : ");
		for(float f : array) {
			System.out.println(f);
		}
		sc.close();
	}

}
