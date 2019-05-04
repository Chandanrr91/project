package com.ds.util;

import com.ds.util.bean.BNode;

public class BinarySearchTree<T extends Comparable<T>> {

	private BNode<T> root;
	private int size;
	private int prevValue;

	public BNode<T> getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}

	private BNode<T> insert(BNode<T> node, T data) {

		if (node == null) {

			BNode<T> newNode = new BNode<T>(data);
			size++;
			return newNode;
		} else {

			if (data.compareTo(node.getData()) < 0) {

				BNode<T> left = insert(node.getLeft(), data);
				node.setLeft(left);
			} else {

				BNode<T> right = insert(node.getRight(), data);
				node.setRight(right);
			}
			return node;

		}
	}

	public void insert(T data) {
		this.root = insert(getRoot(), data);
	}

	public BNode<T> getMin(BNode<T> root) {

		if (root == null) {
			return null;
		} else {
			if (root.getLeft() == null) {
				return root;
			} else {
				return getMin(root.getLeft());
			}
		}

	}

	public BNode<T> getMin() {

		return getMin(getRoot());
	}

	public BNode<T> getMax(BNode<T> root) {

		if (root == null) {
			return null;
		} else {
			if (root.getRight() == null) {
				return root;
			} else {
				return getMax(root.getRight());
			}
		}

	}

	public BNode<T> getMax() {

		return getMax(getRoot());
	}

	public BNode<T> delete(BNode<T> node, T data) {

		if (node == null) {
			return null;
		} else {

			int difference = node.getData().compareTo(data);
			if (difference > 0) {
				node.setLeft(delete(node.getLeft(), data));
				return node;
			} else if (difference < 0) {
				node.setRight(delete(node.getRight(), data));
				return node;
			} else {

				if (node.getLeft() == null) {
					return node.getRight();
				} else if (node.getRight() == null) {
					return node.getLeft();
				} else {
					BNode<T> maxNode = getMax(node.getLeft());
					node.setLeft(delete(node.getLeft(), maxNode.getData()));
					node.setData(maxNode.getData());
					return node;
				}
			}
		}
	}

	public BNode<T> searchElement(BNode<T> node, T data) {

		if (node == null) {
			return null;
		} else {

			int difference = node.getData().compareTo(data);
			if (difference > 0) {
				return searchElement(node.getLeft(), data);
			} else if (difference < 0) {
				return searchElement(node.getRight(), data);
			} else {
				return node;
			}
		}
	}

	public void inOrderTraversal() {

		inOrderTraversal(getRoot());
		System.out.println();
	}

	public boolean isBST(BNode<T> node) {

		if (node == null) {
			return true;
		} else {

			if (node.getLeft() != null) {

				int diff = node.getData().compareTo(getMax(node.getLeft()).getData());
				if (diff < 0) {
					return false;
				}
			}
			if (node.getRight() != null) {
				int diff = node.getData().compareTo(getMin(node.getRight()).getData());
				if (diff > 0) {
					return false;
				}
			}

			boolean left = isBST(node.getLeft());
			if (!left) {
				return left;
			}
			return isBST(node.getRight());
		}

	}

	private boolean isBSTInOrder(BNode<T> node) {

		if (node == null) {
			return true;
		} else {
			boolean left = isBSTInOrder(node.getLeft());
			if (!left) {
				return left;
			}
			int data = (int) node.getData();
			if (data < prevValue) {
				return false;
			}
			prevValue = data;
			return isBSTInOrder(node.getRight());
		}

	}

	public boolean isBSTInOrder() {
		prevValue = Integer.MIN_VALUE;
		return isBSTInOrder(getRoot());
	}

	private void inOrderTraversal(BNode<T> root) {

		if (root == null) {
			return;
		} else {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData() + ",");
			inOrderTraversal(root.getRight());
		}
	}

	public void constructBST(T[] arr) {

		this.root = constructBST(arr, 0, arr.length - 1);
	}

	private BNode<T> constructBST(T[] arr, int start, int end) {

		if (start > end) {
			return null;
		} else {
			int mid = (start + end) >> 1;
			BNode<T> newNode = new BNode<T>(arr[mid]);
			newNode.setLeft(constructBST(arr, start, mid - 1));
			newNode.setRight(constructBST(arr, mid + 1, end));
			return newNode;
		}
	}
}
