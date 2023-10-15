package overriding_exception;

import java.io.FileNotFoundException;

public class B extends A {
	//Test1.java
	/*error occurs as show() mtd in class A does not throw any exception
	* class B is extended from A and show() mtd is overridden
	so show() can not throw new or broader exception than overridden mtd */ 
	
	/*@Override
	public void show() throws InterruptedException {
		System.out.println("2");
	}
	*/
	/*
	public void show() throws Exception{
		System.out.println("2");
	}
	*/
	
	//Test2.java
	/*public void show(){
		System.out.println("2");
	}
	*/
	
	/*
	/*public void show() throws FileNotFoundException{
		System.out.println("2");
	}
	*/
}
