package com.ds.util;

import com.ds.util.bean.Node;

public class LinkedList {

	private Node head;
	private int size;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void append(int data) {

		if (head == null) {
			head = new Node(data);
		} else {

			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			Node newNode = new Node(data);
			temp.setNext(newNode);
		}
		size++;
	}

	public void traverse() {

		Node temp = head;
		while (temp != null) {

			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public void delete(int data) {

		if (head == null) {
			System.out.println("List is empty.");
		} else if (head.getData() == data) {

			Node temp = head.getNext();
			head.setNext(null);
			head = temp;
			size--;
		} else {

			Node prev = head;
			Node curr = head.getNext();
			while (curr != null) {

				if (curr.getData() == data) {

					Node temp = curr.getNext();
					prev.setNext(temp);
					curr.setNext(null);
					size--;
					break;
				} else {
					prev = prev.getNext();
					curr = prev.getNext();
				}
			}
		}

	}

	public void printReverve() {

		// Recursive printing
		printReverse(head);

	}

	/**
	 * Recursive print of LL
	 * 
	 * @param node
	 */
	private void printReverse(Node node) {
		if (node == null) {
			return;
		} else {
			node = node.getNext();
			printReverse(node);
			System.out.println(node.getData());
		}
	}

	public void reverse() {

		reverse(head, null);
	}

	private void reverse(Node prev, Node curr) {

		if (curr == null) {
			head = prev;
			return;
		} else {

			Node temp = curr.getNext();
			prev.setNext(curr);
			reverse(curr, temp);
		}

	}

	private Node getMiddle(Node head) {

		Node midElement = head;

		if (head == null) {
			System.out.println("No data available");
		} else {

			Node fastEle = head.getNext();
			while (fastEle != null && fastEle.getNext() != null) {

				midElement = midElement.getNext();
				fastEle = fastEle.getNext().getNext();
			}
		}
		return midElement;

	}

	public Node getMiddle() {
		return getMiddle(this.head);
	}

	public void iterativeReverse() {

		if (head == null) {
			System.out.println("Empty List");
		} else {
			Node prev = null;
			Node curr = head;
			Node next = head.getNext();
			while (curr != null) {

				next = curr.getNext();
				curr.setNext(prev);
				prev = curr;
				curr = next;
			}
			head = prev;
		}
	}

	private Node mergeLL(Node head1, Node head2) {

		Node mergeHead, mergePointer;
		if (head1.getData() < head2.getData()) {
			mergeHead = mergePointer = head1;
			head1 = head1.getNext();
		} else {
			mergeHead = mergePointer = head2;
			head2 = head2.getNext();
		}
		while (head1 != null && head2 != null) {

			if (head1.getData() < head2.getData()) {
				mergePointer.setNext(head1);
				mergePointer = head1;
				head1 = head1.getNext();
			} else {
				mergePointer.setNext(head2);
				mergePointer = head2;
				head2 = head2.getNext();
			}
		}
		if (head1 != null) {
			mergePointer.setNext(head1);
		} else {
			mergePointer.setNext(head2);
		}
		return mergeHead;
	}

	private Node mergeSort(Node head) {

		if (head == null || head.getNext() == null) {
			return head;
		}

		Node mid = getMiddle(head);
		Node shead = mid.getNext();
		mid.setNext(null);
		Node lhead = mergeSort(head);
		Node rhead = mergeSort(shead);
		return mergeLL(lhead, rhead);
	}

	public void mergeSort() {
		this.head = mergeSort(this.head);
	}
}
