package exerscises;

/**
 * @author mahi9
 *
 */
public class Main {
	public static void main(String[] args) {
		String s = "({[abcd]}";
		
		BalancedExpression be = new BalancedExpression();
		
		System.out.println(be.isBalanced(s));
	}
}
