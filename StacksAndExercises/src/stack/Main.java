package stack;

public class Main {

	public static void main(String[] args) {
		var stack=new MinStack();
		
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		System.out.println(stack.min());
	}
}
