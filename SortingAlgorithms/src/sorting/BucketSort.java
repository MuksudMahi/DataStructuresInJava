package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	public void sort(int[] array) {
		int n=array.length;
		int i=0;
		for (var bucket : createBucket(array, n)) {
			Collections.sort(bucket);
			
			for(var item: bucket)
				array[i++]=item;
		}
	}

	private List<List<Integer>> createBucket(int[] array, int n) {
		List<List<Integer>> buckets = new ArrayList<>();
		for (var i = 0; i < n; i++)
			buckets.add(new ArrayList<>());

		for (var item : array)
			buckets.get(item / n).add(item);

		return buckets;
	}
}
