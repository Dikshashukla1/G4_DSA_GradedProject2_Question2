package com.gl.question2;

public class Transaction {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void ConvertBTToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}
		if (order > 0) {
			ConvertBTToSkewed(root.right, order);
		} else {
			ConvertBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			ConvertBTToSkewed(leftNode, order);
		} else {
			ConvertBTToSkewed(rightNode, order);
		}
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		Transaction tree = new Transaction();
		Transaction.node = new Node(50);
		Transaction.node.left = new Node(30);
		Transaction.node.right = new Node(60);
		Transaction.node.left.left = new Node(10);
		Transaction.node.right.left = new Node(55);

		int order = 0;
		ConvertBTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}
