package exerscises;

import java.util.Stack;

public class ReverseString {

	public String reverse(String input) {
		Stack<Character> reversed = new Stack<Character>();

		for (char ch : input.toCharArray()) {
			reversed.push(ch);
		}

		StringBuffer sb = new StringBuffer();
		while (!reversed.empty()) {
			sb.append(reversed.pop());
		}

		return sb.toString();
	}

}
