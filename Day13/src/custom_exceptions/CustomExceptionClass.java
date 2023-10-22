package custom_exceptions;

@SuppressWarnings("serial")
public class CustomExceptionClass extends Exception {
	public CustomExceptionClass(String msg){
		super(msg);
	}
}
