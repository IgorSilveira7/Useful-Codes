package data.structures.doubleLinkedList;

import data.structures.linkedList.RecursiveLinkedList;

public class RecursiveDoubleLinkedList<T> extends RecursiveLinkedList<T> implements DoubleLinkedListInterface<T> {
	
	protected RecursiveDoubleLinkedList<T> previous;
	
	public RecursiveDoubleLinkedList() {
		
	}
	
	@Override
	public void insert(T element) {
		if(this.isEmpty()) {
			this.data = element;
			RecursiveDoubleLinkedList<T> nil = new RecursiveDoubleLinkedList<>();;
			this.next = nil;
			nil.previous = this;
			if(this.previous == null) {
				this.previous = new RecursiveDoubleLinkedList<>();
			}
		} else {
			this.next.insert(element);
		}
	}
	
	@Override
	public void remove(T element) {
		if(this.isEmpty()) {
			
		} else {
			if(this.data.equals(element)) {
				if(this.next.isEmpty() && this.previous.isEmpty()) {
					this.data = null;
				} else {
					this.data = this.next.getData();
					this.next = this.next.getNext();
					
					if(!this.next.isEmpty()) {
						((RecursiveDoubleLinkedList<T>) this.next).previous = this;
					}
				}
			} else {
			}
			this.next.remove(element);
		}
	}
	
	

	@Override
	public void insertFirst(T element) {
		if(this.isEmpty()) {
			this.data = element;
			RecursiveDoubleLinkedList<T> nil = new RecursiveDoubleLinkedList<>();
			this.next = nil;
			nil.previous = this;
		} else {
			T aux = this.data;
			this.data = element;
			((RecursiveDoubleLinkedList<T>) this.next).insertFirst(aux);
		}
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) {
			
		} else {
			this.data = this.next.getData();
			((RecursiveDoubleLinkedList<T>) this.next).removeFirst();
		}
		
	}

	@Override
	public void removeLast() {
		if(this.isEmpty()) {
			System.out.println(this.data);
			this.previous.previous.next = new RecursiveDoubleLinkedList<T>();
			
		} else {
			((RecursiveDoubleLinkedList<T>) this.next).removeLast();
		}
		
	}

}
