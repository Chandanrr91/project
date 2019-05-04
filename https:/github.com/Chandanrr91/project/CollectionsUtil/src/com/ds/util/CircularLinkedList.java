package com.ds.util;

import com.ds.util.bean.Node;

public class CircularLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public void appendAtLast(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public void traverse() {

		int temp = size;
		Node tempNode = head;
		while (temp-- > 0) {
			System.out.println(tempNode.getData());
			tempNode = tempNode.getNext();
		}

	}

	public void delete(int data) {

		int temp = size;
		Node prev = tail;
		Node curr = head;
		while (temp-- > 0) {

			if (curr.getData() == data) {
				prev.setNext(curr.getNext());
				curr.setNext(null);
				size--;
				curr = prev.getNext();
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
		tail = prev;
		head = curr;
	}

	public void appendAtBegin(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			tail.setNext(newNode);
			head = newNode;
		}
		size++;
	}

}
