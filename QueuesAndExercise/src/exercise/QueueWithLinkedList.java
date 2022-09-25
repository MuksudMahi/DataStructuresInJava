package exercise;

public class QueueWithLinkedList {
	private class Node {
		int value;
		Node next;

		Node(int item) {
			value = item;
		}
	}

	private Node first;
	private Node last;
	private int count;

	public void enqueue(int item) {
		if (isEmpty()) {
			first = last = new Node(item);
			count++;
		}

		else {
			var newNode = new Node(item);
			last.next = newNode;
			last = newNode;
			count++;
		}
	}

	public int dequeue() {
		var secondLast = getPrevious(last);
		var ret = last;
		secondLast.next = null;
		last = secondLast;
		count--;
		return ret.value;

	}

	public int peek() {
		return first.value;
	}

	public int size() {
		return count;
	}

	private Node getPrevious(Node node) {
		Node temp = first;
		while (temp.next != node) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void print() {
		var temp = first;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
