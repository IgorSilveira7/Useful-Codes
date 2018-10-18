package mainzao;

import java.util.Arrays;

import data.structures.linkedList.LinkedList;

public class MainzaoRetorno {
	
	private static LinkedList<Integer> ll = new LinkedList<>();

	public static void main(String[] args) {
		
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		
		System.out.println(ll.toString());
		
		
		System.out.println(ll.indexOf(4));
		

	}

}
