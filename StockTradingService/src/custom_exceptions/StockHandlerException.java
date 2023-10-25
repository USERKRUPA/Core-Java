package custom_exceptions;

public class StockHandlerException extends Exception{

	private static final long serialVersionUID = 1L;

	public StockHandlerException(String message) {
		super(message);
	}
	
}
