package tree;

public class Main {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(30);
		tree.insert(20);
		tree.insert(10);
		tree.insert(25);
//		tree.insert(6);
//		tree.insert(8);
//		tree.insert(10);
		//tree.insert(11);
		
//		Tree tree1 = new Tree();
//		tree1.insert(7);
//		tree1.insert(4);
//		tree1.insert(9);
//		tree1.insert(1);
//		tree1.insert(6);
//		tree1.insert(8);
//		tree1.insert(10);
//		
		//tree.swapRoot();
		//System.out.println(tree.isBST());
//		var list = tree.nodeAtKDistance(1);
//		for(var item : list) {
//			System.out.println(item);
//		}
		
		//tree.traverseLevelOrder();
		//System.out.println(tree.areSibling(8, 6));
//		var list = tree.getAncestors(7);
//		for(var item:list)
//			System.out.println(item);
		tree.traversePreOrder();
	}

}
