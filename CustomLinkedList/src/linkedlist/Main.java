package linkedlist;

public class Main {

	public static void main(String[] args) {
//		var list = new LinkedList();
//		list.addFirst(2);
//		list.addLast(3);
//		list.addFirst(1);
//		list.addLast(4);
//		list.addLast(5);
//		list.addLast(6);
		var list=LinkedList.createWithLoop();
		System.out.println(list.hasLoop());
	}

}
