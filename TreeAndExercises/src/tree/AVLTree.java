package tree;

public class AVLTree {
	private class AVLNode {
		private int value;
		private AVLNode left;
		private AVLNode right;
		private int height;

		public AVLNode(int value) {
			this.value = value;
		}
	}

	private AVLNode root;

	public void insert(int value) {
		root = insert(root, value);
	}

	private AVLNode insert(AVLNode root, int value) {
		if (root == null)
			return new AVLNode(value);
		if (root.value > value) {
			root.left = insert(root.left, value);
		} else if (root.value < value) {
			root.right = insert(root.right, value);
		}
		setHight(root);
		return balance(root);
	}

	private AVLNode balance(AVLNode root) {
		if (isLeftHeavy(root)) {
			if (balanceFactor(root.left) < 0)
				root.left = leftRotation(root.left);
			return rightRotation(root);
		} else if (isRightHeavy(root)) {
			if (balanceFactor(root.right) > 0)
				root.right = rightRotation(root.right);
			return leftRotation(root);
		}
		return root;
	}

	private AVLNode leftRotation(AVLNode root) {
		var newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;

		setHight(root);
		setHight(newRoot);

		return newRoot;
	}

	private AVLNode rightRotation(AVLNode root) {
		var newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;

		setHight(root);
		setHight(newRoot);

		return newRoot;
	}

	private void setHight(AVLNode node) {
		node.height = 1 + (Math.max(height(node.left), height(node.right)));
	}

	private boolean isRightHeavy(AVLNode node) {
		return balanceFactor(node) < -1;
	}

	private boolean isLeftHeavy(AVLNode node) {
		return balanceFactor(node) > 1;
	}

	private int balanceFactor(AVLNode node) {
		return (node == null) ? 0 : height(node.left) - height(node.right);
	}

	private int height(AVLNode node) {
		return (node == null) ? -1 : node.height;
	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(AVLNode root) {
		if (root == null)
			return;

		System.out.println(root.value);
		traversePreOrder(root.left);
		traversePreOrder(root.right);
	}
}
