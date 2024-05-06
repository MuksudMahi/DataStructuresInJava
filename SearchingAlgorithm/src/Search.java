
public class Search {
	public int linerSearch(int[] array, int key) {
		for (var i = 0; i < array.length; i++) {
			if (array[i] == key)
				return i;
		}
		return -1;
	}

	public int binarySearch(int[] array, int key) {
		int left = 0, right = array.length-1;

		while (right >= left) {
			int mid = (left + right) / 2;
			if (key > array[mid])
				left = mid + 1;

			else if (key < array[mid])
				right = mid - 1;

			else
				return mid;
		}

		return -1;
	}

	public int binarySearchRec(int[] array, int key) {
		return binarySearchRec(array, 0, array.length-1, key);
	}

	private int binarySearchRec(int[] array, int left, int right, int key) {
		if (left > right)
			return -1;

		int mid = (right + left) / 2;

		if (array[mid] == key)
			return mid;

		if (array[mid] > key)
			return binarySearchRec(array, left, mid - 1, key);

		return binarySearchRec(array, mid + 1, right, key);

	}
	
	public int ternarySearch(int[] array, int key) {
		return ternarySearch(array, 0, array.length-1, key);
	}
	
	private int ternarySearch(int[] array, int left, int right, int key) {
		if(left>right)
			return -1;
		
		int partition=(right-left)/3;
		int mid1=left+partition;
		int mid2=right-partition;
		
		if(array[mid1]==key)
			return mid1;

		if(array[mid2]==key)
			return mid2;

		if(array[mid1]>key)
			return ternarySearch(array, left, mid1 -1, key);
		
		if(array[mid2]<key)
			return ternarySearch(array, mid2+1, right, key);
		
		return ternarySearch(array, mid1+1, mid2-1, key);
		
	}
}
