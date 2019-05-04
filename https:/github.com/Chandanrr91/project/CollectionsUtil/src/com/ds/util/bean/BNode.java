package com.ds.util.bean;

public class BNode<T> {

	private BNode<T> left;
	private BNode<T> right;
	private T data;

	public BNode(T data) {
		this.data = data;
	}

	public BNode<T> getLeft() {
		return left;
	}

	public void setLeft(BNode<T> left) {
		this.left = left;
	}

	public BNode<T> getRight() {
		return right;
	}

	public void setRight(BNode<T> right) {
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
		return this.data.toString();
	}
}
