package mainzao;

import java.util.Arrays;

import data.structures.linkedList.LinkedList;
import data.structures.queue.CircularQueue;
import data.structures.queue.Queue;
import data.structures.stack.Stack;
import search.algorithms.BuscaBinaria;
import sorting.algorithms.Codes;

public class Main {
	
	private static Codes c = new Codes();
	private static BuscaBinaria b = new BuscaBinaria();
	private static Stack<Integer> pilha = new Stack<Integer>(5);
	private static Queue<Integer> filaNormal = new Queue<Integer>(5);
	private static CircularQueue<Integer> fila = new CircularQueue<Integer>(5);
	private static LinkedList<Integer> ll = new LinkedList<Integer>();

	

	public static void main(String[] args) {
		
		System.out.println(ll.isEmpty());
		System.out.println(ll.size());
		ll.remove(5);
		
		
		ll.insert(5);
		ll.insert(10);
		ll.insert(15);
		ll.insert(20);
		ll.insert(30);
		ll.insert(40);
		
		
		System.out.println(ll.size());
		System.out.println(ll.search(5));
		
		ll.remove(5);
		
		System.out.println(ll.search(5));
		System.out.println(ll.isEmpty());
		System.out.println(ll.size());
		System.out.println(ll.search(10));
		

	}


}
