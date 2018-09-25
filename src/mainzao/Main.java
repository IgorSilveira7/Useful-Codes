package mainzao;

import java.util.Arrays;

import data.structures.CircularQueue;
import data.structures.Queue;
import data.structures.Stack;
import search.algorithms.BuscaBinaria;
import sorting.algorithms.Codes;

public class Main {
	
	private static Codes c = new Codes();
	private static BuscaBinaria b = new BuscaBinaria();
	private static Stack<Integer> pilha = new Stack<Integer>(5);
	private static Queue<Integer> filaNormal = new Queue<Integer>(5);
	private static CircularQueue<Integer> fila = new CircularQueue<Integer>(5);

	

	public static void main(String[] args) {
		
		System.out.println(fila.isEmpty());
		System.out.println(fila.isFull());
		
		System.out.println("------------------------\n");
		
		fila.enqueue(1);
		fila.enqueue(2);
		
		System.out.println(fila.head());
		System.out.println(fila.dequeue());
		
		fila.enqueue(3);
		
		System.out.println(fila.head());
		System.out.println(fila.dequeue());
		
		fila.enqueue(4);
		fila.enqueue(5);
		
		System.out.println(fila.head());
		System.out.println(fila.dequeue());
		
		System.out.println(fila.head());
		System.out.println(fila.dequeue());
		
		System.out.println(fila.head());
		System.out.println(fila.dequeue());
		
		
		System.out.println(fila.head());
		
		

		
	

	}


}
