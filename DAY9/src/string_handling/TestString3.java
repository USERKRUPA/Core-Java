package string_handling;

public class TestString3 {

	public static void main(String[] args) {
		//literal and non literal strings and intern method
		String ls = "Krishna";
		
// memory is allocated on heap for string object and its add 
// is returned by new oprator. address is stored in string ref on stack
		String nls = new String("Krishna");
		System.err.println("ls hashcode: " + ls.hashCode());
		System.err.println("nls hashcode: " + nls.hashCode());
		//content equality
		if(ls.equals(nls))
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
		//ref equality
		if(ls == nls)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
/*nls.intern() method checks string literal pool for the string object 
* that has same value as the one you invoked the intern method
* If one is found, a reference to that String is returned and can be assigned to your local variable.
* Both local variables(here ls and nls), referring to the same String object in the String Literal Pool. 
* At that point, the second String object, which was created at run-time, would be eligible for garbage collection.  
*/
		if(ls == nls.intern())
			System.out.println("Equal");
		else
			System.out.println("Not equal");
		ls = nls = null;//How many objs are marked for GC : 1 (nls)
		//In general, String Literals are not eligible for garbage collection ever.
	}
}
