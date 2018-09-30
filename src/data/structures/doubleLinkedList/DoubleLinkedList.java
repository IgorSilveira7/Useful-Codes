package data.structures.doubleLinkedList;

import data.structures.linkedList.LinkedList;
import data.structures.linkedList.LinkedListNode;

public class DoubleLinkedList<T> extends LinkedList<T> implements DoubleLinkedListInterface<T> {
	
	protected DoubleLinkedListNode<T> last;
	
	@Override
	public void insert(T element) {
		if(this.head.isNull()) {
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, null, null);
			this.head = aux;
			this.last = aux;
			return;
		}
		
		DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) this.head;
		
		while(node.getNext() != null) {
			node = (DoubleLinkedListNode<T>) node.getNext();
		}
		
		DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, null, node);
		
		node.setNext(aux);
		this.last = aux;
	}

	@Override
	public void insertFirst(T element) {
		if(!this.isEmpty()) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) this.head, null);
			((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);
			this.head = newHead;
		}
		
	}

	@Override
	public void removeFirst() {
		this.head = this.head.getNext();
		((DoubleLinkedListNode<T>) this.head).setPrevious(null);
		
	}

	@Override
	public void removeLast() {
		if(this.head.isNull()) return;
		if(this.head.equals(this.last)) {
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<>();
			this.head = aux;
			this.last = aux;
			return;
		}
		this.last = this.last.getPrevious();
		this.last.setNext(null);
		
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
	
	
	
	

}
