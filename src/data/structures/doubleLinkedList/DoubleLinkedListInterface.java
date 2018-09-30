package data.structures.doubleLinkedList;

import data.structures.linkedList.LinkedListInterface;

public interface DoubleLinkedListInterface<T> extends LinkedListInterface<T> {
	
	public void insertFirst(T element);
	
	public void removeFirst();
	
	public void removeLast();

}
