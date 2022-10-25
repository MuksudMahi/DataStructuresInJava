package heap;

public class MinPriorityQueue {
	private MinHeap minHeap=new MinHeap();
	
	public void add(String value, int priority) {
		minHeap.insert(priority, value);
	}
	
	public void remove() {
		minHeap.remove();
	}
	
	public boolean isEmpty() {
		return minHeap.isEmpty();
	}

}
