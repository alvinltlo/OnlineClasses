package test.linkedLists;

public class DoublyLinkedList {

	private Node head = null;

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
			temp.next.previous = temp;
		}
	}

	public void delete(int data) {
		if (head.data == data) {
			head = head.next;
			head.previous = null;
		} else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.data == data) {
					temp.next = temp.next.next;
					temp.next.previous = temp;
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

	/**
	 * print the doubly linkedList in reverse using the previous reference
	 */
	public void reversePrintList() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		// temp is the last element
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.previous;
		}
		System.out.println("");
	}

	public boolean isCircular() {
		Node faster, slower;
		slower = head;
		faster = head.next;

		while (true) {
			if (faster == null || faster.next == null)
				return false;
			else if (faster.next == slower)
				return true;
			else {
				slower = slower.next;
				faster = faster.next.next;
			}
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insert(new Node(1));
		list.insert(new Node(2));
		list.insert(new Node(3));
		list.insert(new Node(4));
		list.printList();
		System.out.println("list is circular: " + list.isCircular());
		list.reversePrintList();
		list.delete(3);
		list.printList();
		list.delete(1);
		list.reversePrintList();

		DoublyLinkedList circularList = new DoublyLinkedList();
		circularList.insert(new Node(1));
		Node n2 = new Node(2);
		circularList.insert(n2);
		circularList.insert(new Node(3));
		Node n4 = new Node(4);
		circularList.insert(n4);
		n4.setNextNode(n2);
		System.out.println("list is circular: " + circularList.isCircular());
	}

}
