package test.linkedLists;

import java.util.Stack;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backward or forward
 */
public class Palindrome {

	public static void main(String[] args) {
		SinglyLinkedList oddList = new SinglyLinkedList();
		oddList.insert(new Node(1));
		oddList.insert(new Node(2));
		oddList.insert(new Node(3));
		oddList.insert(new Node(4));
		oddList.insert(new Node(3));
		oddList.insert(new Node(2));
		oddList.insert(new Node(1));

		SinglyLinkedList evenList = new SinglyLinkedList();
		evenList.insert(new Node(1));
		evenList.insert(new Node(2));
		evenList.insert(new Node(3));
		evenList.insert(new Node(4));
		evenList.insert(new Node(4));
		evenList.insert(new Node(3));
		evenList.insert(new Node(2));
		evenList.insert(new Node(1));

		SinglyLinkedList badList = new SinglyLinkedList();
		badList.insert(new Node(1));
		badList.insert(new Node(2));
		badList.insert(new Node(3));
		badList.insert(new Node(4));
		badList.insert(new Node(3));
		badList.insert(new Node(3));
		badList.insert(new Node(1));

		System.out.println("oddList: " + isPalindrome(oddList));
		System.out.println("evenList: " + isPalindrome(evenList));
		System.out.println("badList: " + isPalindrome(badList));
	}

	public static boolean isPalindrome(SinglyLinkedList list) {
		Node fast = list.getHead();
		Node slow = list.getHead();
		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// Has odd number of elements, skip the middle element
		if (fast != null)
			slow = slow.next;

		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
}
