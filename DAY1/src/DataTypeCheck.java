/*
Accept 2 double values from User (using Scanner). Check data type. If arguments are not doubles , supply suitable error message & terminate. If numbers are double values , print its average.
Hint : Method of Scanner to use :  tDouble , nextDouble 
*/


import java.util.*;
class DataTypeCheck{
	public static void main(String[]args){

		Scanner sc = new Scanner(System.in);
		double sum = 0;
		int count = 1;
		System.out.println("Enter Two Double values: ");
		while(count <= 2){
			if(sc.hasNextDouble())
			 	sum += sc.nextDouble();		
			else{
				System.out.println("Error: Invalid number " + count+ ". Required double value.");
				break;
			}	
			count++;
		}
		if(count == 3)
			System.out.println("Average is: "+ (sum / 2));
		
		sc.close();
        }
}