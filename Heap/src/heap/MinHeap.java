package heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private class Node {
		private int key;
		private String value;

		public Node(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private List<Node> list = new ArrayList<Node>();

	public void insert(int key, String value) {
		list.add(new Node(key, value));
		bubbleUp();
	}

	public void remove() {
		if(isEmpty())
			return;
		var root = list.get(list.size() - 1);
		list.set(0, root);
		list.remove(list.size() - 1);
		bubbleDown();
		//return root;
	}
	
	public boolean isEmpty() {
		return list.size()==0;
	}

	private void bubbleUp() {
		var index = list.size() - 1;
		while (index > 0 && list.get(index).key < list.get(getParentIndex(index)).key) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	private void bubbleDown() {
		int index = 0;
		while (index < list.size() && !isValidParent(index)) {
			var smallerChildIndex = smallerChildIndex(index);
			swap(index, smallerChildIndex);
			index=smallerChildIndex;
		}
	}

	private int smallerChildIndex(int index) {
		if(!hasLeftChild(index))
			return index;
		if(!hasRightChild(index))
			return leftChildIndex(index);
		return (leftChild(index).key < rightChild(index).key) ? leftChildIndex(index) : rightChildIndex(index);
	}

	private boolean isValidParent(int index) {
		if (!hasLeftChild(index))
			return true;
		var isValid = list.get(index).key <= leftChild(index).key;
		if (hasRightChild(index))
			return isValid &= rightChild(index).key <= list.get(index).key;
		return isValid;
	}

	private Node rightChild(int index) {
		return list.get(rightChildIndex(index));
	}

	private boolean hasRightChild(int index) {
		return rightChildIndex(index) <= list.size() - 1;
	}

	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}

	private Node leftChild(int index) {
		return list.get(leftChildIndex(index));
	}

	private boolean hasLeftChild(int index) {
		return leftChildIndex(index) <= list.size() - 1;
	}

	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private void swap(int first, int second) {
		var temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}
	

	public void print() {
		for (var item : list) {
			System.out.println(item.key + " " + item.value);
		}
	}
}
