package my.experiment.code;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left;
	Node right;

	boolean checkBST(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (root != null) {
			root = q.remove();
			if (root.left.data > root.data || root.right.data < root.data) {
				return false;

			} else {
				q.add(root.left);
				q.add(root.right);
			}
		}
		return true;

	}
}
