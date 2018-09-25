package data.structures;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

public class Queue<T> implements QueueInterface<T> {
	
	private T[] array;
	private int tail;
	
	public Queue(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(tail == array.length - 1) {
			throw new QueueOverflowException("Error: Fila cheia");
		} else if(element != null) {
			array[++tail] = element;
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result;
		
		if(tail == -1) {
			throw new QueueUnderflowException("Error: Fila vazia");
		} else {
			result = array[0];
			this.shiftLeft();
			tail--;
		}
		
		return result;
	}

	@Override
	public T head() {
		T result = null;
		
		if(tail > -1) {
			result = array[0];
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result = true;
		
		if(tail > -1) {
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean isFull() {
		boolean result = false;
		
		if(tail == array.length - 1) {
			result = true;
		}
		
		return result;
	}
	
	private void shiftLeft() {
		int i = 0;
		while(array[i] != null && i < array.length - 1) {
			array[i] = array[i + 1];
			i++;
		}
	}

}
