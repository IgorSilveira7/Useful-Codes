package exceptions;

public class QueueUnderflowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QueueUnderflowException(String msg) {
		super(msg);
	}

}
