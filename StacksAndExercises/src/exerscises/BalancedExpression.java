package exerscises;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {
	private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
	private final List<Character> rightBrackets = Arrays.asList(')','}',']','>');

	public boolean isBalanced(String str)
	{
		Stack<Character>exp=new Stack<Character>();
		
		for(char ch : str.toCharArray())
		{
			if(isLeftBracket(ch))
				exp.push(ch);
			
			else if(isRightBracket(ch))
			{
				if(exp.empty()) return false;
				
				var top = exp.pop();
				
				if(!isBracketsMatch(top, ch))
					return false; 
			}
		}
		return (exp.empty());
	}
	
	private boolean isLeftBracket(char ch)
	{
		return leftBrackets.contains(ch);
	}
	
	private boolean isRightBracket(char ch)
	{
		return rightBrackets.contains(ch);
	}
	
	private boolean isBracketsMatch(char left, char right)
	{
		return leftBrackets.indexOf(left)==rightBrackets.indexOf(right);
	}
}
