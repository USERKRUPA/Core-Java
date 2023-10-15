package TestOverriding;

import java.io.IOException;

import overriding_exception.A;
import overriding_exception.B;

public class Test2 {
	public static void main(String[] args) throws IOException{
		A ref = new B();
		ref.show(); //calls to B's show() : o/p 2
	}
}
