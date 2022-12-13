package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
	public static int ALPHABET_SIZE = 26;

	private class Node {
		private char value;
		private HashMap<Character, Node> childrens = new HashMap<>();
		private boolean isEndOfWord;

		public Node(char value) {
			this.value = value;
		}

		public boolean hasChildren(char ch) {
			return childrens.containsKey(ch);
		}

		public boolean hasChildren() {
			return !childrens.isEmpty();
		}

		public void addChildren(char ch) {
			childrens.put(ch, new Node(ch));
		}

		public Node getChildren(char ch) {
			return childrens.get(ch);
		}

		public Node[] getChildren() {
			return childrens.values().toArray(new Node[0]);
		}

		public void removeChild(char ch) {
			childrens.remove(ch);
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}

	private Node root = new Node(' ');

	public void insert(String word) {
		var current = root;
		for (char ch : word.toCharArray()) {
			if (!current.hasChildren(ch))
				current.addChildren(ch);
			current = current.getChildren(ch);
		}
		current.isEndOfWord = true;
	}

	public void remove(String word) {
		if (word == null)
			return;
		remove(root, word, 0);
	}

	private void remove(Node root, String word, int index) {
		if (index == word.length()) {
			root.isEndOfWord = false;
			return;
		}

		var ch = word.charAt(index);
		var child = root.getChildren(ch);
		if (child == null)
			return;

		remove(child, word, index + 1);

		if (!child.hasChildren() && !child.isEndOfWord)
			root.removeChild(ch);
	}

	public boolean contains(String word) {
		var current = root;
		for (char ch : word.toCharArray()) {
			if (!current.hasChildren(ch))
				return false;
			current = current.getChildren(ch);
		}
		return current.isEndOfWord;
	}

	public boolean containsRecursive(String word) {
		if (word == null)
			return false;
		return containsRecursive(root, word, 0);
	}

	private boolean containsRecursive(Node root, String word, int index) {
		if (index == word.length())
			return root.isEndOfWord;
		if (root == null)
			return false;
		var ch = word.charAt(index);
		var child = root.getChildren(ch);
		if (child == null)
			return false;
		return containsRecursive(child, word, index + 1);
	}

	public List<String> findWords(String prefix) {
		List<String> list = new ArrayList<>();
		var lastNode = lastNode(prefix);
		findWords(lastNode, prefix, list);
		return list;
	}

	private void findWords(Node root, String prefix, List<String> list) {
		if (root == null)
			return;
		if (root.isEndOfWord)
			list.add(prefix);
		for (var child : root.getChildren())
			findWords(child, prefix + child.value, list);
	}
	
	public int countWords() {
		return countWords(root);
	}
	
	public static String longestCommonPrefix(String[] words) {
		 if(words==null)
			 return "";
		 var trie=new Trie();
		 for(var word:words)
			 trie.insert(word);
		 
		 var prefix=new StringBuffer();
		 var maxChars=getShortestString(words).length();
		 var current=trie.root;
		 while(prefix.length()<maxChars) {
			 var children=current.getChildren();
			 if(children.length!=1)
				 break;
			 current=children[0];
			 prefix.append(current.value);
		 }
		 return prefix.toString();
	}
	
	private static String getShortestString(String[] words) {
		if(words==null||words.length==0)
			return "";
		
		var shortest=words[0];
		for(var i=1;i<words.length;i++) {
			if(words[i].length()<shortest.length())
				shortest=words[i];
		}
		return shortest;
	}
	
	private int countWords(Node root) 
	{
		var total=0;
		
		if(root.isEndOfWord)
			total++;
		
		for(var child : root.getChildren())
			total+=countWords(child);
		
		return total;
	
	}
	
	private Node lastNode(String prefix) {
		if (prefix == null)
			return null;
		var current = root;
		for (var ch : prefix.toCharArray()) {
			var child = current.getChildren(ch);
			if (child == null)
				return null;
			current = child;
		}
		return current;
	}

}
