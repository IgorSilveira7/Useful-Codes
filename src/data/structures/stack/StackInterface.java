package data.structures.stack;

import exceptions.StackUnderflowException;

public interface StackInterface<T> {
	
	
	public void push(T element) throws StackOverflowError;
	
	public T pop() throws StackUnderflowException;
	
	public T top();
	
	public boolean isEmpty();
	
	public boolean isFull();

}
