package com.ds.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ds.util.bean.BNode;

public class BinaryTree<T> {

	private BNode<T> root;
	private int size = 0;

	public BNode<T> getRoot() {
		return root;
	}

	public BinaryTree(BNode<T> root) {
		this.root = root;
	}

	public BinaryTree() {
	}

	public void insertLevelOrder(T data) {

		if (root == null) {
			root = new BNode<T>(data);
		} else {
			Queue<BNode<T>> queue = new Queue<>();
			queue.enqueue(root);
			while (!queue.isEmpty()) {

				BNode<T> temp = queue.dequeue();
				if (temp.getLeft() == null) {
					temp.setLeft(new BNode<T>(data));
					size++;
					return;
				} else {
					queue.enqueue(temp.getLeft());
				}
				if (temp.getRight() == null) {
					temp.setRight(new BNode<T>(data));
					size++;
					return;
				} else {
					queue.enqueue(temp.getRight());
				}

			}
		}
	}

	public int getSize() {
		return size;
	}

	public void levelOrderTraversal() {

		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			Queue<BNode<T>> queue = new Queue<>();
			queue.enqueue(root);
			while (!queue.isEmpty()) {
				BNode<T> temp = queue.dequeue();
				if (temp.getLeft() != null) {
					queue.enqueue(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.enqueue(temp.getRight());
				}
				System.out.println(temp.getData());
			}
		}
	}

	public void preOrderTraversal() {

		System.out.println("------------Pre Order-------");
		preOrderTraversal(root);
	}

	public void inOrderTraversal() {

		System.out.println("------------In Order-------");
		inOrderTraversal(root);
	}

	public void postOrderTraversal() {

		System.out.println("------------Post Order-------");
		postOrderTraversal(root);
	}

	private void preOrderTraversal(BNode<T> node) {

		if (node == null) {
			return;
		} else {
			System.out.print(node.getData());
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
	}

	private void inOrderTraversal(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			inOrderTraversal(node.getLeft());
			System.out.print(node.getData());
			inOrderTraversal(node.getRight());
		}
	}

	private void postOrderTraversal(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.print(node.getData());
		}
	}

	public void printLeavesLeft2Right() {

		printLeavesLeft2Right(root);
	}

	private void printLeavesLeft2Right(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			if (node.getLeft() == null && node.getRight() == null) {
				System.out.print(node.getData());
			}
			printLeavesLeft2Right(node.getLeft());
			printLeavesLeft2Right(node.getRight());
		}
	}

	public void printLeavesRight2Left() {

		printLeavesRight2Left(root);
	}

	private void printLeavesRight2Left(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			if (node.getLeft() == null && node.getRight() == null) {
				System.out.print(node.getData());
			}
			printLeavesRight2Left(node.getRight());
			printLeavesRight2Left(node.getLeft());
		}
	}

	private void printLeftTree(BNode<T> node) {

		if (node == null) {
			return;
		} else {
			if (node.getLeft() != null || node.getRight() != null) {
				System.out.print(node.getData());
			}
			if (node.getLeft() != null) {
				printLeftTree(node.getLeft());
			} else {
				printLeftTree(node.getRight());
			}
		}
	}

	private void printRightReverseTree(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			if (node.getRight() != null) {
				printRightReverseTree(node.getRight());
			} else {
				printRightReverseTree(node.getLeft());
			}
			if ((node.getLeft() != null || node.getRight() != null) && !node.equals(root)) {
				System.out.print(node.getData());
			}
		}
	}

	private void printLeftReverseTree(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			if (node.getLeft() != null) {
				printLeftReverseTree(node.getLeft());
			} else {
				printLeftReverseTree(node.getRight());
			}
			if ((node.getLeft() != null || node.getRight() != null) && !node.equals(root)) {
				System.out.print(node.getData());
			}
		}
	}

	private void printRightTree(BNode<T> node) {

		if (node == null) {
			return;
		} else {

			if (node.getLeft() != null || node.getRight() != null) {
				System.out.print(node.getData());
			}

			if (node.getRight() != null) {
				printRightReverseTree(node.getRight());
			} else {
				printRightReverseTree(node.getLeft());
			}
		}
	}

	public void printTreeBoundaryAntiClockwise() {

		printLeftTree(root);
		printLeavesLeft2Right(root);
		printRightReverseTree(root);
		System.out.println();
	}

	public void printTreeBoundaryClockwise() {

		printRightTree(root);
		printLeavesRight2Left();
		printLeftReverseTree(root);
		System.out.println();
	}

	private void delete(BNode<T> node) {

		if (node == null) {
			return;
		} else {
			delete(node.getLeft());
			delete(node.getRight());
			if (node.getLeft() != null) {
				node.setLeft(null);
			}
			if (node.getRight() != null) {
				node.setRight(null);
			}
		}
	}

	public void delete() {
		delete(root);
		root = null;
	}

	private Integer maxElementInt(BNode<Integer> node) {

		if (node == null) {
			return 0;
		} else {

			int left = maxElementInt(node.getLeft());
			int right = maxElementInt(node.getRight());
			// return returnMax(node, maxElementInt(node.getLeft()),
			// maxElementInt(node.getRight()));
			int max = returnMax(node, left, right);
			return max;
		}

	}

	private int returnMax(BNode<Integer> node, int left, int right) {

		int max = left > right ? left : right;
		int rootData = (Integer) node.getData();
		max = max > rootData ? max : rootData;
		return max;
	}

	public void maxElement() {

		if (root == null) {
			System.out.println("Tree is empty");
		} else if (root.getData() instanceof Integer) {
			System.out.println(maxElementInt((BNode<Integer>) root));
		} else {
			System.out.println("Unsupported type of data.");
		}
	}

	private int height(BNode<T> node) {

		if (node == null) {
			return 0;
		} else {
			int leftHeight = height(node.getLeft());
			int rightHeight = height(node.getRight());
			int height = rightHeight > leftHeight ? rightHeight : leftHeight;
			return 1 + height;
		}

	}

	public void displayHeight() {

		System.out.println(height(root));
	}

	private boolean contains(BNode<T> node, T data) {

		if (node == null) {
			return false;
		} else {

			if (node.getData().equals(data)) {
				return true;
			}

			boolean left = contains(node.getLeft(), data);
			if (left)
				return left;
			boolean right = contains(node.getRight(), data);
			return right;
		}
	}

	public boolean contains(T data) {

		return contains(root, data);
	}

	private boolean identical(BNode<T> node1, BNode<T> node2) {

		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 == null || node2 == null) {
			return false;
		} else {

			boolean left = identical(node1.getLeft(), node2.getLeft());
			if (!left)
				return left;
			boolean right = identical(node1.getRight(), node2.getRight());
			return right;
		}
	}

	public boolean identicalTree(BinaryTree<T> btree) {

		return identical(root, btree.getRoot());
	}

	private BNode<T> mirrorImage(BNode<T> node) {
		if (node == null) {
			return null;
		} else {

			BNode<T> newNode = new BNode<T>(node.getData());
			newNode.setRight(mirrorImage(node.getLeft()));
			newNode.setLeft(mirrorImage(node.getRight()));
			return newNode;
		}
	}

	public BinaryTree<T> mirrorImage() {
		return new BinaryTree<>(mirrorImage(this.root));
	}

	private int diameter(BNode<T> root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.getLeft());
		int rheight = height(root.getRight());

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.getLeft());
		int rdiameter = diameter(root.getRight());

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

	}

	public int diameter() {
		return diameter(root);
	}

	private int getLevel(BNode<T> node, T data, int level) {

		if (node == null) {
			return -1;
		} else {

			if (node.getData().equals(data)) {
				return 1;
			}

			int left = getLevel(node.getLeft(), data, level);
			if (left != -1) {
				return ++left;
			}
			int right = getLevel(node.getRight(), data, level);
			if (right != -1) {
				return ++right;
			}
			return right;
		}
	}

	private boolean printAncestors(BNode<T> node, T data) {

		if (node == null) {
			return false;
		} else {

			if (node.getData().equals(data)) {
				return true;
			}
			boolean left = printAncestors(node.getLeft(), data);
			if (left) {
				System.out.println(node.getData());
				return left;
			}
			boolean right = printAncestors(node.getRight(), data);
			if (right) {
				System.out.println(node.getData());
			}
			return right;
		}
	}

	private boolean nodePath(BNode<T> node, T data, List<BNode<T>> nodeList) {

		if (node == null) {
			return false;
		} else {
			nodeList.add(node);
			if (node.getData().equals(data)) {
				return true;
			}
			boolean left = nodePath(node.getLeft(), data, nodeList);
			if (left) {
				return left;
			}
			boolean right = nodePath(node.getRight(), data, nodeList);
			if (right) {
				return right;
			}

			nodeList.remove(node);
			return false;
		}
	}

	public BNode<T> LCA(BNode<T> node1, BNode<T> node2) {
		List<BNode<T>> node1Path = new ArrayList<>();
		boolean node1Present = nodePath(getRoot(), node1.getData(), node1Path);
		if (!node1Present) {
			System.out.println("Node1 is missing");
			return null;
		}
		List<BNode<T>> node2Path = new ArrayList<>();
		boolean node2Present = nodePath(getRoot(), node2.getData(), node2Path);
		if (!node2Present) {
			System.out.println("Node2 is missing");
			return null;
		}
		System.out.println(node1Path.toString());
		System.out.println(node2Path.toString());
		int i;
		for (i = 0; i < node1Path.size() && i < node2Path.size(); i++) {

			if (!node1Path.get(i).equals(node2Path.get(i))) {
				break;
			}
		}

		return node1Path.get(i - 1);
	}

	void printAncestors(T data) {

		printAncestors(root, data);
	}

	public int findLevel(T data) {
		return getLevel(root, data, 0);
	}

	private int diameter2(BNode<T> node) {

		if (node == null) {
			return 0;
		}

		int left = diameter2(node.getLeft());
		int right = diameter2(node.getRight());

		int leftHeight = height(node.getLeft());
		int rightHeight = height(node.getRight());

		int returnDia = left > right ? left : right;
		if (returnDia < (leftHeight + rightHeight + 1)) {
			returnDia = leftHeight + rightHeight + 1;
		}

		return returnDia;

	}

	public int diameter2() {
		return diameter2(root);

	}

	boolean isCousins(BNode<T> node1, BNode<T> node2) {

		int node1Level = getLevel(getRoot(), node1.getData(), 0);
		int node2Level = getLevel(getRoot(), node2.getData(), 0);

		return ((node1Level == node2Level) && !(isSiblings(getRoot(), node1, node2)));
	}

	private boolean isSiblings(BNode<T> root, BNode<T> node1, BNode<T> node2) {

		if (root == null || root.getLeft() == null || root.getRight() == null) {
			return false;
		}

		if ((root.getLeft().getData().equals(node1.getData()) && root.getRight().getData().equals(node2.getData()))
				|| root.getRight().getData().equals(node1.getData())
						&& root.getLeft().getData().equals(node2.getData())) {
			return true;
		}

		boolean left = isSiblings(root.getLeft(), node1, node2);
		if (left) {
			return left;
		}
		boolean right = isSiblings(root.getRight(), node1, node2);
		return right;

	}
}
