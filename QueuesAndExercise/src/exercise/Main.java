package exercise;

public class Main {

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.add(30);
		queue.add(10);
		queue.add(5);
		queue.add(1);
		queue.add(20);
		System.out.println(queue.toString());
		while(!queue.isEmpty())
			System.out.println(queue.remove());
	}

}
