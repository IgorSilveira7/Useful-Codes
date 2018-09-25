package exceptions;

public class QueueOverflowException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QueueOverflowException(String msg) {
		super(msg);
	}

}
