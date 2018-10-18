package data.structures.queue;

import data.structures.stack.Stack;
import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

public class QueueTwoStacksImpl<T> implements QueueInterface<T> {
	
	private Stack<T> mainStack;
	private Stack<T> auxStack;
	private int tail;
	
	public QueueTwoStacksImpl(int size) {
		this.mainStack = new Stack<>(size);
		this.auxStack = new Stack<>(size);
		this.tail = -1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!this.isFull()) {
			this.mainStack.push(element);
		} else {
			throw new QueueOverflowException("Fila cheia!");
		}
		
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!this.isEmpty()) {
			T result;
			
			while(!this.mainStack.isEmpty()) {
				this.auxStack.push(this.mainStack.pop());
			}
			
			result = this.auxStack.pop();
			
			while(!this.auxStack.isEmpty()) {
				this.mainStack.push(this.auxStack.pop());
			}
			
			return result;
		
		} else {
			throw new QueueUnderflowException("Fila vazia!");
		}
		
			
	}

	@Override
	public T head() {
		T result = null;
		
		if(!this.isEmpty()) {
			
			while(!this.mainStack.isEmpty()) {
				this.auxStack.push(this.mainStack.pop());
			}
			
			result = this.auxStack.top();
			
			while(!this.auxStack.isEmpty()) {
				this.mainStack.push(this.auxStack.pop());
			}
			
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		if(!this.isEmpty()) {
			
			while(!this.mainStack.isEmpty()) {
				this.auxStack.push(this.mainStack.pop());
			}
			
			
			
			while(!this.auxStack.isEmpty()) {
				result += this.auxStack.top() + " ";
				this.mainStack.push(this.auxStack.pop());
			}
			
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.mainStack.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.mainStack.isFull();
	}

}
