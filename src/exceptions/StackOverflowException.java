package exceptions;

public class StackOverflowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StackOverflowException(String msg) {
		super(msg);
	}

}
