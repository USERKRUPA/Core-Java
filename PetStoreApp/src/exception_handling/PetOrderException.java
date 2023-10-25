package exception_handling;

public class PetOrderException extends Exception{

	private static final long serialVersionUID = 1L;

	public PetOrderException(String message) {
		super(message);
	}

}
