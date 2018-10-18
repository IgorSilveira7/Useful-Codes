package mainzao;

import java.util.Arrays;

import data.structures.doubleLinkedList.RecursiveDoubleLinkedList;
import data.structures.linkedList.LinkedList;
import data.structures.linkedList.RecursiveLinkedList;
import data.structures.queue.CircularQueue;
import data.structures.queue.Queue;
import data.structures.queue.QueueTwoStacksImpl;
import data.structures.stack.Stack;
import search.algorithms.BuscaBinaria;
import sorting.algorithms.Codes;

public class Main {
	
	private static QueueTwoStacksImpl<Integer> fila = new QueueTwoStacksImpl<>(5);

	

	public static void main(String[] args) {
		
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
	
		System.out.println(fila.isFull());
		
		System.out.println(fila.toString());
		
		fila.dequeue();
		
		System.out.println(fila.toString());
		
		fila.dequeue();
		
		System.out.println(fila.toString());
		
		fila.dequeue();
		
		System.out.println(fila.toString());
		
		fila.dequeue();
		
		System.out.println(fila.toString());
		
		fila.dequeue();
		
		System.out.println(fila.isEmpty());

	}


}
