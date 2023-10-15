package TestOverriding;

import overriding_exception.A;
import overriding_exception.B;

public class Test1{

	public static void main(String[] args){
		A ref = new B();
		ref.show();
	}
}
