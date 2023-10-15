import java.util.*;

class Factorial {
	public static void main(String[] args){
		int fact = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		for(int i = num ; i >= 1 ; i--){
			fact = fact * i;
		}
		System.out.println("Factorial of " + num + " is :"  + fact);
	}
}