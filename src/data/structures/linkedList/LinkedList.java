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
			result = 1;
			LinkedListNode<T> node = this.head;
			
			while(node.getNext() != null) {
				result++;
				node = node.getNext();
			}
		}
		
		return result;
	}

	@Override
	public T search(T element) {
		T result = null;
		LinkedListNode<T> node = this.head;
		
		if(this.head.getData().equals(element)) {
			result = this.head.getData();
		} else {
			while(node.getNext() != null) {
				node = node.getNext();
				
				if(node.getData().equals(element)) {
					result = node.getData();
				}
				
				
			}
		}
		
		return result;
	}

	@Override
	public void insert(T element) {
		if(this.head.isNull()) {
			this.head = new LinkedListNode<T>(element, null);
			return;
		}
		
		LinkedListNode<T> node = this.head;
		
		while(node.getNext() != null) {
			node = node.getNext();
		}
		
		node.setNext(new LinkedListNode<T>(element, null));
		
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

}
