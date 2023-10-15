package com.acts.tester;
import java.util.Scanner;
class Array{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of an array: ");
		float[] arr = new float[sc.nextInt()];
		System.out.println("Class of  arr is: "+arr.getClass());
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i] + ",");
		}
		sc.close();
	}
}
