package test.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {

	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}

	public static void insert(Node node, int newValue) {
		if (newValue < node.value) {
			if (node.left != null) {
				insert(node.left, newValue);
			} else {
				System.out.println("Insert " + newValue + " to left.");
				node.left = new Node(newValue);
			}
		} else if (newValue > node.value) {
			if (node.right != null) {
				insert(node.right, newValue);
			} else {
				System.out.println("Insert " + newValue + " to right.");
				node.right = new Node(newValue);
			}
		}
	}

	public static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.value + ",");
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + ",");
	}

	public static void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + ",");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static int findMin(Node node) {
		if (node.left == null)
			return node.value;
		else
			return findMin(node.left);
	}

	public static int findMax(Node node) {
		if (node.right == null)
			return node.value;
		else
			return findMax(node.right);
	}

	public static Node findNode(Node node, int key) {
		if (node == null) {
			System.out.println("Cannot find key = " + key);
			return null;
		}
		if (key < node.value)
			return findNode(node.left, key);
		if (key > node.value)
			return findNode(node.right, key);
		else {
			System.out.println("Find node key = " + key);
			return node;
		}
	}

	/**
	 * LinkedIn Interivew Prep
	 * Q7: Common Ancestor in Tree
	 */
	public static Node findCommonAncestor(Node node, int key1, int key2) {
		if (node == null) {
			System.out.println("\nThere is no common ancestor");
			return null;
		}
		//current node value is smaller than both keys
		if (node.value < key1 && node.value < key2)
			return findCommonAncestor(node.right, key1, key2);
		//current node value is bigger than both keys
		else if (node.value > key1 && node.value > key2)
			return findCommonAncestor(node.left, key1, key2);
		else {
			System.out.println("\nFind common ancestor: " + node.value);
			return node;
		}
	}

	public static boolean isTreeEquals(Node tree1, Node tree2) {
		if (tree1 == tree2)
			return true; // check if they are reference the same tree.
		if (tree1 == null || tree2 == null)
			return false;
		if (tree1.value != tree2.value)
			return false;
		if (!isTreeEquals(tree1.left, tree2.left))
			return false;
		if (!isTreeEquals(tree1.right, tree2.right))
			return false;
		return true;
	}

	/**
	 * Ask by MapR phone interview 5
	 * 
	 * 3 6
	 * 
	 * 7 4 -1 Given root of the tree, along with an random integer n. Find out
	 * whether or not there exists a complete path in this tree, such that the
	 * sum of all the nodes along the paths=n. n=12
	 * 
	 * 1. happy path 2. first node is = n; 3. path include negative value 4.
	 * Integer.max and Intger.min 5. root is == null
	 */
	public static boolean hasPath(Node node, int n) {
		// base case
		if (node == null)
			return false;
		int temp = n - node.value;
		if (temp == 0 && node.left == null && node.right == null)
			return true;
		if (node.left != null)
			return hasPath(node.left, temp);
		if (node.right != null)
			return hasPath(node.right, temp);
		return false;
	}

	public static Node remove(int value, Node node) {
		if (node == null)
			return null;
		if (value < node.value) {
			node.left = remove(value, node.left);
		} else if (value > node.value) {
			node.right = remove(value, node.right);
		} else {
			if (node.left != null && node.right != null) {
				node.value = findMin(node.right);
				remove(node.value, node.right);
			}
			if (node.left == null)
				return node.right;
			if (node.right == null)
				return node.left;
		}
		return node;
	}

	public static int findHeight(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}

	public static void breadthFirstSearch(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null)
			return;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.print(n.value + ", ");
			if (n.left != null)
				queue.add(n.left);
			if (n.right != null)
				queue.add(n.right);
		}
	}

	public static void breadthFirstSearchPrintLevel(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null)
			return;
		int currentCount = 1, nextCount = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			currentCount--;
			System.out.print(n.value + ", ");
			if (n.left != null) {
				queue.add(n.left);
				nextCount++;
			}
			if (n.right != null) {
				queue.add(n.right);
				nextCount++;
			}
			if (currentCount == 0) {
				System.out.print("\n");
				currentCount = nextCount;
				nextCount = 0;
			}
		}
	}

	public static Node mirrorRecursive(Node n) {
		if (n == null)
			return null;
		else {
			Node newNode = new Node(n.value);
			newNode.left = mirrorRecursive(n.right);
			newNode.right = mirrorRecursive(n.left);
			return newNode;
		}
	}

	public static Node mirrorIterative(Node n) {
		if (n == null || (n.left == null && n.right == null))
			return n;
		Node parent = n;
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		while (!stack.empty()) {
			parent = stack.pop();

			Node temp = parent.right;
			parent.right = parent.left;
			parent.left = temp;

			if (parent.right != null)
				stack.push(parent.right);
			if (parent.left != null)
				stack.push(parent.left);
		}
		return n;
	}

	public static boolean areMirrorTrees(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 == null)
			return false;
		return n1.value == n2.value && areMirrorTrees(n1.left, n2.right)
		        && areMirrorTrees(n1.right, n2.left);
	}

	public static int countLeafNodes(Node n) {
		if (n == null)
			return 0;
		if (n.left == null && n.right == null)
			return 1;
		return countLeafNodes(n.left) + countLeafNodes(n.right);
	}

	public static String serializeToString(Node n) {
		if (n == null) {
			return "# ";
		}
		return n.value + " " + serializeToString(n.left)
		        + serializeToString(n.right);
	}

	static int index = 0;

	public static Node deserializeToTree(String str) {
		if (str == null || str.length() == 0)
			return null;
		return deserializeToTree(str.split(" "));
	}

	public static Node deserializeToTree(String[] str) {
		if (index >= str.length)
			return null;
		if (str[index].equals("#")) {
			index++;
			return null;
		}
		Node n = new Node(Integer.parseInt(str[index]));
		index++;
		n.left = deserializeToTree(str);
		n.right = deserializeToTree(str);
		return n;
	}

	public static void main(String[] arg) {
		Node root = new Node(20);
		insert(root, 25);
		insert(root, 15);
		insert(root, 30);
		insert(root, 10);
		insert(root, 22);
		insert(root, 18);

		System.out.println("\nIn-Order: ");
		inOrder(root);
		System.out.println("\nPre-Order: ");
		preOrder(root);
		System.out.println("\nPost-Order: ");
		postOrder(root);

		System.out.println("\nBreadth first search:");
		breadthFirstSearch(root);
		System.out.println("\nBreadth first search with level:");
		breadthFirstSearchPrintLevel(root);

		System.out.println("\nSerialize:");
		System.out.println(serializeToString(root));

		System.out.println("\nDe-Serialize:");
		Node newTree = deserializeToTree(serializeToString(root));
		breadthFirstSearchPrintLevel(newTree);

		System.out.println("\nmirror");
		breadthFirstSearchPrintLevel(mirrorRecursive(root));
		breadthFirstSearchPrintLevel(mirrorIterative(root));
		System.out.println("Not Mirror Tree: " + areMirrorTrees(root, root));
		System.out.println("Are Mirror Tree: " + areMirrorTrees(root, mirrorRecursive(root)));

		System.out.println("\nCount leaf Nodes");
		System.out.println(countLeafNodes(root));

		System.out.println("\nMin is " + findMin(root));
		System.out.println("Max is " + findMax(root));
		System.out.println("Height is " + findHeight(root));

		findNode(root, 1);
		findNode(root, 22);

		System.out.println("\nIn-Order: ");
		inOrder(root);
		remove(18, root);
		System.out.println("\nAfter remove In-Order: ");
		inOrder(root);
		findCommonAncestor(root, 10, 18);

		Node root2 = new Node(20);
		insert(root2, 25);
		insert(root2, 15);
		insert(root2, 30);
		insert(root2, 10);
		insert(root2, 22);
		insert(root2, 18);

		System.out.println(isTreeEquals(root, root2));
		System.out.println("hasPath = " + hasPath(root2, 45));
		System.out.println("hasPath = " + hasPath(root2, 100));
	}
}
