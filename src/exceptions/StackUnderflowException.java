package exceptions;

public class StackUnderflowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StackUnderflowException(String msg) {
		super(msg);
	}

}
