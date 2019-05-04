package com.ds.util.bean;

public class AugmentedBNode<T> {

	private AugmentedBNode<T> left;
	private AugmentedBNode<T> right;
	private T data;
	private int size;

	public AugmentedBNode(T data) {
		this.data = data;
		this.size = 1;
	}

	public AugmentedBNode<T> getLeft() {
		return left;
	}

	public void setLeft(AugmentedBNode<T> left) {
		this.left = left;
	}

	public AugmentedBNode<T> getRight() {
		return right;
	}

	public void setRight(AugmentedBNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "data:" + this.data.toString() + " size:" + this.size;
	}

	public int getSize() {
		return size;
	}

	public void incrementSize() {
		this.size++;
	}
}
