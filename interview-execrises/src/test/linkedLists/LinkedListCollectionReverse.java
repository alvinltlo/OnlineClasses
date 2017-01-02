package test.linkedLists;

import java.util.*;

/**
 * This class show the static Reverse method from the Collections class 
 *
 */
public class LinkedListCollectionReverse {

	public static void main(String args[]) {
		// create a linked list
		LinkedList<String> ll = new LinkedList<String>();
		// add elements to the linked list
		ll.add("F");
		ll.add("B");
		ll.add("D");
		ll.add("E");
		ll.add("C");
		
		System.out.println("Orginal linked List");
		Iterator iterator = ll.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}

		reverseWithFunction(ll);
	}
	
	public static void reverseWithFunction(LinkedList<String> ll)
	{
		System.out.println("\nReverse order Using Reverse function");
		Iterator iterator = ll.iterator();
		Collections.reverse(ll);
		iterator = ll.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");

		}
	}
}
