package data.structures;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

public class Stack<T> implements StackInterface<T>{
	
	private T[] array;
	private int top;
	
	public Stack(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public void push(T element) throws StackOverflowError {
		if(top == array.length - 1) {
			throw new StackOverflowException("Error: Pilha cheia");
		} else {
			array[++top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result;
		
		if(top == -1) {
			throw new StackUnderflowException("Error: Pilha vazia");
		} else {
			return array[top--];
		}
	}

	@Override
	public T top() {
		T result = null;
		
		if(top != -1) {
			result = array[top];
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		
		if(top == -1) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean isFull() {
		boolean result;
		
		if(top == array.length - 1) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}

}
