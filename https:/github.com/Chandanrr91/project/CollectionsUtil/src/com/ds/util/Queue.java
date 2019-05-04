package com.ds.util;

import com.ds.util.bean.DNode;

public class Queue<T> {

	private DNode<T> head;
	private DNode<T> tail;

	public void enqueue(T data) {

		DNode<T> newNode = new DNode<T>(data);
		if (head == null && tail == null) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	public T dequeue() {

		if (head == null && tail == null) {
			System.out.println("Queue is empty.");
			return null;
		} else {
			T node = head.getData();
			head = head.getNext();

			if (head == null) {
				tail = null;
			} else {
				head.setPrev(null);
			}
			return node;
		}
	}

	public void tranverse() {

		DNode<T> temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

}
