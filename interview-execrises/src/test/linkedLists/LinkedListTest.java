package test.linkedLists;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListTest llt = new LinkedListTest();
		LinkList list = llt.new LinkList();

		System.out.println("Create a list by inserting from the front");
		list.insertFront(1);
		list.insertFront(2);
		list.insertFront(3);
		list.insertFront(4);
		list.insertFront(5);
		list.printList();

		System.out.println("Print the list in reverse (using recursive)");
		list.first = list.reverseRecursively(list.first);
		list.printList();

		System.out.println("Print the list in reverse (using loop)");
		list.reverse();
		list.printList();

		System.out.println("Create a list by inserting from the back");
		list = llt.new LinkList();
		list.insertBack(1);
		list.insertBack(2);
		list.insertBack(3);
		list.insertBack(4);
		list.insertBack(5);
		list.printList();

		// while (!list.isEmpty()) {
		// Node deletedLink = list.deleteFirstElement();
		// System.out.print("deleted: ");
		// deletedLink.printLink();
		// System.out.println("");
		// }
		// list.printList();

	}

	class Node {
		public int data1;
		public Node nextLink;

		// Link constructor
		public Node(int d1) {
			data1 = d1;
		}

		// Print Link data
		public void printLink() {
			System.out.print("{" + data1 + "} ");
		}
	}

	class LinkList {
		private Node first;
		private Node last;

		// LinkList constructor
		public LinkList() {
			first = null;
		}

		// Returns true if list is empty
		public boolean isEmpty() {
			return first == null;
		}

		// Inserts a new Link at the first of the list
		public void insertFront(int d1) {
			Node link = new Node(d1);
			link.nextLink = first;
			first = link;
		}

		public void insertBack(int d1) {
			Node link = new Node(d1);
			link.nextLink = null;
			if (first != null) {
				last.nextLink = link;
				last = link;
			} else {
				// when the link is empty
				first = link;
				last = link;
			}
		}

		// Deletes the link at the first of the list
		public Node deleteFirstElement() {
			if (first != null) {
				Node temp = first;
				first = first.nextLink;
				return temp;
			} else
				return null;
		}

		// Prints list data
		public void printList() {
			Node currentLink = first;
			System.out.print("List: ");
			while (currentLink != null) {
				currentLink.printLink();
				currentLink = currentLink.nextLink;
			}
			System.out.println("");
		}

		public Node reverseRecursively(Node node) {
			if (node == null || node.nextLink == null)
				return node;
			Node nextItem = node.nextLink;
			node.nextLink = null;

			Node reverseRest = reverseRecursively(nextItem);
			nextItem.nextLink = node;

			return reverseRest;
		}

		public void reverse() {
			// setup [before/first -> mid -> after]
			Node before = first;
			Node mid, after;

			mid = first.nextLink;
			after = mid.nextLink;

			// clear before's nextlink
			before.nextLink = null;

			while (after != null) {
				mid.nextLink = before;
				before = mid;
				mid = after;
				after = after.nextLink;
			}

			// setting other node back
			mid.nextLink = before;
			first = mid;
		}
	}
}
