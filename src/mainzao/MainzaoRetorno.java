package mainzao;

import java.util.Arrays;

import data.structures.linkedList.LinkedList;

public class MainzaoRetorno {
	
	private static LinkedList<Integer> ll = new LinkedList<>();

	public static void main(String[] args) {
		
		ll.insertOrdered(7);
		ll.insertOrdered(9);
		ll.insertOrdered(1);
		ll.insertOrdered(5);
		ll.insertOrdered(11);
		ll.insertOrdered(13);
		
		
		System.out.println(ll.toString());
		
		
		
		

	}

}
