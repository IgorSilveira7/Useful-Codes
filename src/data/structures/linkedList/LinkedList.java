package data.structures.linkedList;


public class LinkedList<T> implements LinkedListInterface<T> {
	
	protected LinkedListNode<T> head;
	
	public LinkedList() {
		this.head = new LinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.head.isNull());
	}

	@Override
	public int size() {
		Integer result = 0;
		
		if(!isEmpty()) {
			LinkedListNode<T> node = this.head;
			
			while(!node.isNull()) {
				result++;
				node = node.getNext();
			}
		}
		
		return result;
	}

	@Override
	public T search(T element) {
		LinkedListNode<T> node = this.head;
		
		while(!node.isNull() && !node.getData().equals(element)) {
			node = node.getNext();
		}
		
		return node.getData();
	}

	@Override
	public void insert(T element) {
		if(this.head.isNull()) {
			LinkedListNode<T> newHead = new LinkedListNode<T>(element, this.head);
			this.head = newHead;
			return;
		}
		
		LinkedListNode<T> node = this.head;
		
		while(!node.getNext().isNull()) {
			node = node.getNext();
		}
		
		LinkedListNode<T> newNode = new LinkedListNode<T>(element, node.getNext());
		node.setNext(newNode);
		
		
	}

	@Override
	public void remove(T element) {
		
		if(this.head.isNull()) return;
		if(this.head.getData().equals(element)) {
			this.head = this.head.getNext();
			return;
		}
		LinkedListNode<T> node = this.head;
		
		
		while(node.getNext() != null) {
			if(node.getNext().getData().equals(element)) {
				node.setNext(node.getNext().getNext());
				return;
			}
			
			node = node.getNext();
		}
		
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		
		LinkedListNode<T> aux = this.head;
		
		int i = 0;
		
		while(!aux.isNull()) {
			array[i] = aux.getData();
			aux = aux.getNext();
			i++;
		}
		
		return array;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		LinkedListNode<T> aux = this.head;
		
		while(!aux.isNull()) {
			result += aux.getData() + " ";
			aux = aux.getNext();
		}
		
		return result;
		
	}
	
	public void reverseList() {
		
		LinkedListNode<T> prev = new LinkedListNode<>();
		LinkedListNode<T> current = this.head;
		LinkedListNode<T> next;
		
		while(!current.isNull()) {
			
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		this.head = prev;
	}
	
	
	
	public int maxElement() {
		int max = 0;
		
		LinkedListNode<T> aux = this.head;
		
		while(!aux.isNull()) {
			if((int) aux.getData() > max) {
				max = (int) aux.getData();
			}
			
			aux = aux.getNext();
		}
		
		return max;
	}
	
	public int indexOf(T element) {
		int index = -1;
		
		if(!this.isEmpty()) {
			
			LinkedListNode<T> aux = this.head;
			
			while(!aux.isNull() && aux.getData() != element) {
				aux = aux.getNext();
				index++;
			}
			
			if(aux.isNull()) {
				index = -1;
			} else {
				index++;
			}
			
			
		}
		
		return index;
	}
	
	
	
	
	
	

}
