package com.ds.util;

import com.ds.util.bean.AugmentedBNode;

public class AugmentedBST<T extends Comparable<T>> {

	private AugmentedBNode<T> root;
	private int size;

	public AugmentedBNode<T> getRoot() {
		return root;
	}

	public void setRoot(AugmentedBNode<T> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void insert(T data) {
		this.root = insert(getRoot(), data);
	}

	private AugmentedBNode<T> insert(AugmentedBNode<T> node, T data) {

		if (node == null) {
			AugmentedBNode<T> newNode = new AugmentedBNode<>(data);
			size++;
			return newNode;
		} else {

			int difference = node.getData().compareTo(data);
			if (difference > 0) {
				AugmentedBNode<T> left = insert(node.getLeft(), data);
				node.setLeft(left);
			} else {
				AugmentedBNode<T> right = insert(node.getRight(), data);
				node.setRight(right);
			}
			node.incrementSize();
			return node;
		}
	}

	public void display() {

		inOrderDisplay(getRoot());
		System.out.println();
	}

	private void inOrderDisplay(AugmentedBNode<T> node) {

		if (node == null) {
			return;
		} else {
			inOrderDisplay(node.getLeft());
			System.out.print(node.toString() + ";");
			inOrderDisplay(node.getRight());
		}

	}

	public AugmentedBNode<T> getKthElement(int index) {
		return getKthElement(getRoot(), index);
	}

	private AugmentedBNode<T> getKthElement(AugmentedBNode<T> node, int kIndex) {

		if (node == null) {
			return node;
		} else {
			AugmentedBNode<T> nodeLeft = node.getLeft();

			int currIndex = 0;
			if (nodeLeft == null) {
				currIndex = 1;
			} else {
				currIndex = nodeLeft.getSize() + 1;
			}
			if (currIndex == kIndex) {
				return node;
			} else if (kIndex > currIndex) {
				kIndex = kIndex - currIndex;
				return getKthElement(node.getRight(), kIndex);
			} else {
				return getKthElement(node.getLeft(), kIndex);
			}
		}

	}

}
