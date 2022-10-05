package tree;

import java.util.ArrayList;

public class Tree {
	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node=" + value;
		}
	}

	private Node root;

	public void insert(int value) {
		var node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}

		var current = root;
		while (true) {
			if (value < current.value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			} else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			}
		}
	}

	public boolean find(int value) {
		var current = root;

		while (current != null) {
			if (value < current.value)
				current = current.leftChild;
			else if (value > current.value)
				current = current.rightChild;
			else
				return true;
		}

		return false;
	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(Node root) {
		if (root == null)
			return;

		System.out.println(root.value);
		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);
	}

	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(Node root) {
		if (root == null)
			return;

		traverseInOrder(root.leftChild);
		System.out.println(root.value);
		traverseInOrder(root.rightChild);
	}

	public void traversePostOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(Node root) {
		if (root == null)
			return;

		traversePostOrder(root.leftChild);
		traversePostOrder(root.rightChild);
		System.out.println(root.value);
	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if (isEmpty())
			return -1;

		if (isLeaf(root))
			return 0;
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	public int min() {
		return min(root);
	}

	private int min(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;

		if (isLeaf(root))
			return root.value;

		var left = min(root.leftChild);
		var right = min(root.rightChild);

		return Math.min(Math.min(left, right), root.value);
	}

	public int max() {
		return max(root);
	}

	private int max(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;

		if (isLeaf(root))
			return root.value;

		var left = max(root.leftChild);
		var right = max(root.rightChild);

		return Math.max(Math.max(left, right), root.value);
	}

	public int minBST() {
		if (isEmpty())
			return -1;

		var current = root;
		var last = current;

		while (current != null) {
			last = current;
			current = current.leftChild;
		}

		return last.value;
	}

	public boolean equals(Tree other) {
		if (isEmpty() || other.isEmpty())
			return false;
		return equals(root, other.root);
	}

	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;
		if (first != null && second != null)
			return first.value == second.value && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);
		return false;
	}

	public void swapRoot() {
		var temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int leftRange, int rightRange) {
		if (root == null)
			return true;

		return root.value <= rightRange && root.value >= leftRange && isBST(root.leftChild, leftRange, root.value - 1)
				&& isBST(root.rightChild, root.value + 1, rightRange);
	}

	public ArrayList<Integer> nodeAtKDistance(int k) {
		var list = new ArrayList<Integer>();
		nodeAtKDistance(root, k, list);
		return list;
	}

	private void nodeAtKDistance(Node root, int k, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}

		if (k == 0) {
			list.add(root.value);
			return;
		}
		nodeAtKDistance(root.leftChild, k - 1, list);
		nodeAtKDistance(root.rightChild, k - 1, list);
	}

	public void traverseLevelOrder() {
		for (var i = 0; i <= height(); i++) {
			for (var item : nodeAtKDistance(i)) {
				System.out.println(item);
			}
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node root) {
		if (root == null)
			return 0;
		if (isLeaf(root))
			return 1;

		return 1 + size(root.leftChild) + size(root.rightChild);
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node root) {
		if (root == null)
			return 0;
		if (isLeaf(root))
			return 1;

		return countLeaves(root.leftChild) + countLeaves(root.rightChild);
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node root, int value) {
		if (root == null)
			return false;
		if (root.value == value)
			return true;
		return contains(root.leftChild, value) || contains(root.rightChild, value);
	}

	public boolean areSibling(int value1, int value2) {
		return areSibling(root, value1, value2);
	}

	private boolean areSibling(Node root, int value1, int value2) {
		if (isLeaf(root))
			return false;
		if (root.leftChild.value == value1 && root.rightChild.value == value2
				|| root.leftChild.value == value2 && root.rightChild.value == value1)
			return true;

		return areSibling(root.leftChild, value1, value2) || areSibling(root.rightChild, value1, value2);
	}

	public ArrayList<Integer> getAncestors(int value) {
		var list = new ArrayList<Integer>();
		getAncestors(root, value, list);
		return list;
	}

	private boolean getAncestors(Node root, int value, ArrayList<Integer> list) {
		if (root == null)
			return false;
		if (root.value == value)
			return true;
		if (getAncestors(root.leftChild, value, list) || getAncestors(root.rightChild, value, list)) {
			list.add(root.value);
			return true;
		}
		return false;
	}

	private boolean isEmpty() {
		return root == null;
	}

	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}
}
