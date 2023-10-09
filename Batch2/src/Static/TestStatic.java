package Static;
import static java.lang.System.*;
class TestStatic {
	private int x;
	private static int y; // static data member
	// we can initialize data member(static and non static) 
	// while declaring them but it's not good practice.
	
	TestStatic() {
		 out.println("Inside constructor: "+ x);
		x = 20;
		 out.println("Exiting from constructor: "+ x);
	}
	//non static initializer block is used to initialize instance data members
	{
		 out.println("Inside instance initializer block: "+ x);
		x = 10;
		 out.println("Exiting from instance initializer block: " + x);
	}
	
	//static initializer block is used to initialize static data member
	static {
		 out.println("Inside static Block 1: "+ y);
		y = 100;
	}
	static {
		 out.println("Inside static Block 2: "+ y);
	}
	//more than one static block is allowed in one file
	//order of execution of static block depends on order in which they are written
	
	public static void getStaticData() {
		 out.println("Instide static member function: ");
		// out.println("x = "+ x); // error
		//can only access static data member
		 out.println("y = "+ y);
	}
	public void nonStaticMethod() {
		 out.println("Instide non static member function: ");
		 out.println("x = "+ x);
		//can access static and non static data member
		 out.println("y = "+ y);
	}
	public static void main(String[] args) {
		TestStatic ts = new TestStatic();
		//static method can be called with or without object
		//ts.getStaticData(); 
		getStaticData(); // or TestStatic.getStaticData();
		ts.nonStaticMethod();
	}

}
