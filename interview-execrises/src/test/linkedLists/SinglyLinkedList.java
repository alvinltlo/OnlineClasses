package test.linkedLists;

public class SinglyLinkedList {

	private Node head = null;

	public Node getHead() {
		return head;
	}
	
	public void setHead(Node n) {
		head = n;
	}
	
	private Node tail = null;

	public void insert(Node n) {
		if (head == null) {
			head = n;
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
	}

	/**
	 * insert a node when tail reference is maintained
	 */
	public void insertWithTail(Node n) {
		if (head == null) {
			head = n;
			tail = n;
			return;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	/**
	 * Delete a node when tail reference is maintained
	 */
	public void deleteWithTail() {
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node temp = head;
			while (temp.next != tail) {
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
		}
	}

	/**
	 * Delete a node that contains specific data. Tail reference is maintained.
	 */
	public void deleteWithTail(int data) {
		if (head.data == data) {
			if (head == tail) {
				head = head.next;
				tail = head.next;
			} else
				head = head.next;
		} else if (tail.data == data) {
			deleteWithTail();
		} else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.data == data) {
					temp.next = temp.next.next;
				}
				temp = temp.next;
			}
		}
	}

	public void delete(int data) {
		if (head.data == data) {
			head = head.next;
		} else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.data == data) {
					temp.next = temp.next.next;
				}
				temp = temp.next;
			}
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("");
	}

	public static void printReverseRecursive(Node n){
		if (n == null)
			return;
		printReverseRecursive(n.next);
		System.out.print(n.data + " ") ;
	}
	
	public static Node reverseRecursive(Node node){
		if (node.next == null)
			return node;
		Node next = node.next;
		node.next = null;
		Node reverse = reverseRecursive(next);
		next.next = node;
		return reverse;
	}
	
	public void reverseIterative() {
		Node before = head;
		Node mid = head.next;
		Node after = mid.next;
		
		before.next = null;
		
		while (after != null) {
			mid.next = before;
			before = mid;
			mid = after;
			after = after.next;
		}
		mid.next = before;
		head = mid;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(new Node(1));
		list.insert(new Node(2));
		list.insert(new Node(3));
		list.insert(new Node(4));
		list.printList();
		list.setHead(reverseRecursive(list.getHead()));
		list.printList();
		list.reverseIterative();
		list.printList();
		printReverseRecursive(list.getHead());
		System.out.println("\n");
		
		list.delete(3);
		list.printList();
		list.delete(1);
		list.printList();

		SinglyLinkedList listWithTail = new SinglyLinkedList();
		listWithTail.insertWithTail(new Node(10));
		listWithTail.insertWithTail(new Node(11));
		listWithTail.insertWithTail(new Node(12));
		listWithTail.insertWithTail(new Node(13));
		listWithTail.printList();
		listWithTail.deleteWithTail();
		listWithTail.printList();
		listWithTail.insertWithTail(new Node(15));
		listWithTail.printList();
		listWithTail.deleteWithTail(11);
		listWithTail.printList();
		listWithTail.deleteWithTail(10);
		listWithTail.printList();
		listWithTail.deleteWithTail(15);
		listWithTail.printList();
	}
}
