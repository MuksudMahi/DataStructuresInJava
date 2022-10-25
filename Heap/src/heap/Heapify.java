package heap;

public class Heapify {
	public static void heapify(int[] array) {
		var lastParentIndex = array.length / 2 - 1;
		for (int i = lastParentIndex; i >= 0; i--) {
			heapify(array, i);
		}
	}

	private static void heapify(int[] array, int index) {
		var largerIndex = index;

		var leftIndex = index * 2 + 1;
		if (leftIndex < array.length && array[index] < array[leftIndex])
			largerIndex = leftIndex;

		var rightIndex = index * 2 + 2;
		if (rightIndex < array.length && array[index] < array[rightIndex])
			largerIndex = rightIndex;

		if (index == largerIndex)
			return;
		swap(array, index, largerIndex);

		heapify(array, largerIndex);
	}

	private static void swap(int[] array, int index, int largerIndex) {
		var temp = array[index];
		array[index] = array[largerIndex];
		array[largerIndex] = temp;

	}
	
	public static int getKthLargest(int[] array, int k) {
		var heap = new Heap();
		for(int item : array)
			heap.insert(item);
		heap.print();
		for(int i=0; i<k-1; i++)
			heap.remove();
		
		return heap.max();
	}
}
