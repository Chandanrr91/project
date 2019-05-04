package com.ds.util.bean;

public class DNode<T> {

	private DNode<T> prev;
	private DNode<T> next;
	private T data;

	public DNode(T data) {
		this.data = data;
	}

	public DNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DNode<T> prev) {
		this.prev = prev;
	}

	public DNode<T> getNext() {
		return next;
	}

	public void setNext(DNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
