package exercise;

import java.util.Arrays;

public class ArrayQueue {
	private int[] items;
	private int count;
	private int rear;
	private int front;

	public ArrayQueue(int capacity) {
		items = new int[capacity];
	}

	public void enqueue(int item) {
		if (isFull())
			throw new IllegalStateException();
		items[rear] = item;
		rear = (rear + 1) % items.length;
		count++;
	}

	public int dequeue() {
		if (isEmpty())
			throw new IllegalStateException();
		var item = items[front];
		items[front] = 0;
		front = (front + 1) % items.length;
		count--;
		return item;
	}

	private boolean isEmpty() {
		return count == 0;
	}

	private boolean isFull() {
		return count == items.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}
}
