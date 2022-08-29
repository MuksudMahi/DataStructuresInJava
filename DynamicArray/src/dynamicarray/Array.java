package dynamicarray;

public class Array {
	private int[] arr;
	private int currPos;

	public Array(int length) {
		arr = new int[length];
	}

	public void insert(int item) {
		resizeIfRequired();
		arr[currPos++] = item;
	}

	public void removeAt(int idx) {
		if (idx < 0 || idx >= currPos)
			throw new IllegalArgumentException();

		for (int i = idx; i < currPos - 1; i++) {
			arr[i] = arr[i + 1];
		}
		currPos--;
	}

	public int indexOf(int item) {
		for (int i = 0; i < currPos; i++) {
			if (arr[i] == item) {
				return i;
			}
		}
		return -1;
	}

	public int max() {
		int arrMax = arr[0];
		for (int item : arr) {
			if (item > arrMax)
				arrMax = item;
		}
		return arrMax;
	}

	public Array intersect(Array arrToCompare) {
		var intersection = new Array(currPos);
		for (int item : arr) {
			if (arrToCompare.indexOf(item) >= 0) {
				intersection.insert(item);
			}
		}
		//intersection.print();
		return intersection;
	}

	public void reverse() {
		int[] reversedArr = new int[currPos];
		for (int i = currPos; i > 0; i--) {
			reversedArr[currPos - i] = arr[i - 1];
		}
		arr = reversedArr;
	}

	public void insertAt(int item, int idx) {
		if (idx < 0 || idx > currPos) {
			throw new IllegalArgumentException();
		}
		resizeIfRequired();
		for (int i = currPos - 1; i >= idx; i--) {
			arr[i + 1] = arr[i];
		}
		arr[idx] = item;
		currPos++;

	}

	public void resizeIfRequired() {
		if (arr.length == currPos) {
			int[] newArr = new int[currPos * 2];
			for (int i = 0; i < currPos; i++) {
				newArr[i] = arr[i];
			}

			arr = newArr;

		}
	}

	public void print() {
		for (int i = 0; i < currPos; i++) {
			System.out.println(arr[i]);
		}
	}
}
