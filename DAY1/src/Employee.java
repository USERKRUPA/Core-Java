/*Write java application to accept int(emp id) , double(salary) , emp's first name , is permanent :  boolean from Scanner & display the same using printf*/


import java.util.*;
class Employee{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Id: ");		
		int empId = sc.nextInt();
		System.out.println("Employee salary: ");
		double salary = sc.nextDouble();
		System.out.println("Employee name: ");
		String name = sc.next();
		System.out.println("Permanent(True or False): ");
		Boolean isPermanent = sc.nextBoolean();
		System.out.printf("Employee Id: %d\nSalary: %f\nName: %s\nPermanent: %s\n", empId, salary, name, isPermanent);
		sc.close();
	}
}