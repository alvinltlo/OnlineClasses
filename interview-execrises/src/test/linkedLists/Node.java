package test.linkedLists;

public class Node {
	Node next = null;
	Node previous = null;
	int data;

	public Node(int d) {
		data = d;
	}

	public void setNextNode(Node n) {
		next = n;
	}

	public void setPreviousNode(Node n) {
		previous = n;
	}

}
