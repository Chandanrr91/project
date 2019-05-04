package com.ds.util;

import com.ds.util.bean.Node;

public class Stack {

	private Node head;

	public void push(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void pop() {

		if (head == null) {
			System.out.println("Stack is empty.");
			return;
		} else {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

	public void peek() {

		if (head == null) {
			System.out.println("Stack is empty.");
			return;
		} else {
			System.out.println(head.getData());
		}
	}

	public void traverse() {

		Node temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}
