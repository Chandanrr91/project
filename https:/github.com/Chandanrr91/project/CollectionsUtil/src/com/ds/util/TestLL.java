package com.ds.util;

import com.ds.util.bean.BNode;

public class TestLL {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(12);
		ll.append(13);
		ll.append(14);
		ll.append(16);
		ll.append(1);
		ll.append(15);

		// ll.traverse();
		ll.iterativeReverse();
		ll.traverse();

		ll.getMiddle();

		System.out.println("-------Merge sort-------");
		ll.mergeSort();
		ll.traverse();
		System.out.println("------CLL------");
		CircularLinkedList cll = new CircularLinkedList();
		cll.appendAtBegin(10);
		cll.appendAtBegin(11);
		cll.appendAtBegin(10);
		cll.appendAtBegin(10);
		cll.appendAtLast(40);
		cll.traverse();
		System.out.println("------------");
		cll.delete(100);
		cll.traverse();

		System.out.println("------Stack------");
		Stack stack = new Stack();
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.traverse();
		System.out.println("------------");
		stack.peek();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("------------");
		stack.traverse();

		System.out.println("------Queue-------");
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(19);
		queue.enqueue(16);
		queue.tranverse();
		System.out.println("-------------------");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println("-------------------");
		queue.tranverse();

		System.out.println("------------BTree-------");
		BinaryTree<Integer> tree = new BinaryTree<>();
		for (int i = 1; i < 16; i++) {
			tree.insertLevelOrder(i);
		}
		tree.preOrderTraversal();
		System.out.println();
		tree.inOrderTraversal();
		System.out.println();
		tree.postOrderTraversal();
		System.out.println();
		tree.levelOrderTraversal();
		System.out.println("---BTree leaves---");
		tree.printLeavesLeft2Right();
		System.out.println();
		System.out.println("---BTree Boundary Anti Clockwise---");
		tree.printTreeBoundaryAntiClockwise();
		System.out.println("---BTree Boundary Clockwise---");
		tree.printTreeBoundaryClockwise();
		// System.out.println("---BTree Delete---");
		// tree.delete();
		// tree.levelOrderTraversal();
		tree.maxElement();
		System.out.println("---------Height----");
		tree.displayHeight();
		System.out.println("Contains:" + tree.contains(13));
		System.out.println("Contains:" + tree.contains(25));

		BinaryTree<Integer> tree2 = new BinaryTree<>();
		for (int i = 0; i < 16; i++) {
			tree2.insertLevelOrder(i);
		}

		System.out.println("Identical:" + tree.identicalTree(tree2));

		/*
		 * BinaryTree mirror = tree.mirrorImage(); mirror.levelOrderTraversal();
		 */
		System.out.println("Diameter:" + tree.diameter2());

		System.out.println("Level :" + tree.findLevel(17));

		tree.printAncestors(10);

		System.out.println("Is cousins:" + tree.isCousins(new BNode<Integer>(7), new BNode<Integer>(8)));

		BNode<Integer> data = tree.LCA(new BNode<Integer>(7), new BNode<Integer>(3));
		if (data != null) {
			System.out.println("LCA:" + data.getData());
		}

	}
}
