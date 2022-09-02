package linkedlist;

class LinkedList {
	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;
	private int size;

	public void addFirst(int value) {
		var newNode = new Node(value);
		if (first == null)
			first = last = newNode;
		else {
			newNode.next = first;
			first = newNode;
		}
		size++;
	}

	public void addLast(int value) {
		var newNode = new Node(value);
		if (isEmpty())
			first = last = newNode;
		else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	public void deleteFirst() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		else if (first == last)
			first = last = null;
		else {
			var second = first.next;
			first.next = null;
			first = second;
		}
		size--;
	}

	public void deleteLast() {
		if (!isEmpty()) {
			if (first == last)
				first = last = null;
			else {
				var secondLast = getPrevious(last);
				secondLast.next = null;
				last = secondLast;
			}
			size--;
		}
	}

	private Node getPrevious(Node node) {
		var current = first;
		while (current != null) {
			if (current.next == node)
				return current;
			current = current.next;
		}
		return null;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public int indexOf(int item) {
		int index = 0;
		var current = first;
		while (current != null) {
			if (current.value == item)
				return index;
			else {
				current = current.next;
				index += 1;
			}
		}
		return -1;
	}

	public int size() {
		return size;
	}

	private boolean isEmpty() {
		return first == null;
	}

	public void reverse() {
		if (!isEmpty()) {
			Node prev = null;
			var current = first;
			Node nxt = null;
			while (current != null) {
				nxt = current.next;
				current.next = prev;
				prev = current;
				current = nxt;
			}
			last = first;
			first = prev;
		}
	}

	public int getKthFromTheEnd(int k) {
		if (isEmpty())
			throw new IllegalStateException();

		Node a = first;
		Node b = last;
		for (int i = 0; i < k - 1; i++) {
			a = a.next;
			if (a == null)
				throw new IllegalArgumentException();
		}
		while (b != null) {
			a = a.next;
			b = b.next;
		}
		return a.value;
	}

	public void printMiddle() {
		if (isEmpty())
			throw new IllegalStateException();

		Node a = first;
		Node b = first;

		while (b != last && b.next != last) {
			b = b.next.next;
			a = a.next;
		}

		if (b == last)
			System.out.print(a.value);
		else
			System.out.print(a.value+", "+a.next.value);
	}
	
	public boolean hasLoop()
	{
		Node a=first;
		Node b=first;
		
		while(b!=null && b.next!=null)
		{
			b=b.next.next;
			a=a.next;
			if(b==a)
			{
				return true;
			}
		}
		return false;
	}
	
	public static LinkedList createWithLoop()
	{
		var list=new LinkedList();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		var temp=list.last;
		list.addLast(40);
		list.addLast(50);
		list.last.next=temp;
		return list;
	}

	public void print() {
		var node = first;
		if (!isEmpty()) {
			while (node != null) {
				System.out.println(node.value);
				node = node.next;
			}
		} else
			System.out.println("Empty list");
	}
}