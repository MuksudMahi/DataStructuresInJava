package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private List<Integer> list = new ArrayList<Integer>();

	public void insert(int val) {
		list.add(val);
		bubbleUp();
	}

	public int remove() {
		int root = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		bubbleDown();
		return root;
	}

	public int max() {
		return list.get(0);
	}

	public static boolean isMaxHeap(int[] array) {
		return isMaxHeap(array, 0);
	}

	private static boolean isMaxHeap(int[] array, int index) {
		var lastParentindex = (array.length - 1) / 2;
		if (index >= lastParentindex)
			return true;

		var leftChildIndex = index * 2 + 1;
		var rightChildIndex = index * 2 + 2;

		var isValid = array[index] >= array[leftChildIndex] && array[index] >= rightChildIndex;
		return isValid && isMaxHeap(array, leftChildIndex) && isMaxHeap(array, rightChildIndex);
	}

	private void bubbleUp() {
		int index = list.size() - 1;
		while (index > 0 && list.get(index) > list.get(getParent(index))) {
			swap(index, getParent(index));
			index = getParent(index);
		}
	}

	private void bubbleDown() {
		int index = 0;
		while (index <= list.size() && !isValidParent(index)) {
			var largerChildIndex = largerChildIndex(index);
			swap(index, largerChildIndex);
			index = largerChildIndex;
		}
	}

	private void swap(int first, int second) {
		int temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}

	private boolean hasLeftChild(int index) {
		return leftChildIndex(index) <= list.size() - 1;
	}

	private boolean hasRightChild(int index) {
		return rightChildIndex(index) <= list.size() - 1;
	}

	private int largerChildIndex(int index) {
		if (!hasLeftChild(index))
			return index;
		if (!hasRightChild(index))
			return leftChildIndex(index);

		return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
	}

	private boolean isValidParent(int index) {
		if (!hasLeftChild(index))
			return true;
		var isValid = list.get(index) >= leftChild(index);

		if (hasRightChild(index))
			isValid &= list.get(index) >= rightChild(index);

		return isValid;
	}

	private int getParent(int index) {
		return (index - 1) / 2;
	}

	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}

	private int leftChild(int index) {
		return list.get(leftChildIndex(index));
	}

	private int rightChild(int index) {
		return list.get(rightChildIndex(index));
	}

	public void print() {
		System.out.println(list.toString());
	}
}
