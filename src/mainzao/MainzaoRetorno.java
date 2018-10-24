package mainzao;

import java.util.Arrays;

import data.structures.doubleLinkedList.DoubleLinkedList;
import data.structures.linkedList.LinkedList;
import data.structures.linkedList.LinkedListNode;

public class MainzaoRetorno {
	
	private static LinkedList<Integer> l1 = new LinkedList<>();
	private static LinkedList<Integer> l2 = new LinkedList<>();
	
	

	public static void main(String[] args) {
		
		l1.insert(1);
		l1.insert(3);
		l1.insert(5);
		l1.insert(7);
		l1.insert(9);
		
		l2.insert(2);
		l2.insert(4);
		l2.insert(6);
		l2.insert(8);
		
		merge(l1, l2);
		
		System.out.println(Arrays.toString(l1.toArray()));
		
		
		
		

	}
	
	public static void merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		
		LinkedListNode<Integer> aux1;
		LinkedListNode<Integer> aux2 = l2.getHead();
		
		while(!aux2.isNull()) {
			if(aux2.getData() < l1.getHead().getData()) {
				l1.insertFirst(aux2.getData());
				aux2 = aux2.getNext();
			} else {
				aux1 = l1.getHead();
				
				boolean adicionou = false;
				
				while(!aux1.getNext().isNull()) {
					
					if(aux1.getNext().getData() > aux2.getData() && !adicionou) {
						LinkedListNode<Integer> temp = new LinkedListNode<Integer>(aux2.getData(), aux2.getNext());
						temp.setNext(aux1.getNext());
						aux1.setNext(temp);
						adicionou = true;
					}
					
					aux1 = aux1.getNext();
				}
				
				if(aux1.getData() < aux2.getData()) {
					LinkedListNode<Integer> temp = new LinkedListNode<Integer>(aux2.getData(), aux2.getNext());
					temp.setNext(aux1.getNext());
					aux1.setNext(temp);
				}
			}
			
			aux2 = aux2.getNext();
		}
		
	}

}
