package com.ds.util;

public class TestBST {

	public static void main(String[] args) {

		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(7);
		tree.insert(13);
		tree.insert(17);
		tree.insert(16);
		tree.insert(19);
		tree.insert(25);
		tree.insert(21);
		tree.insert(20);
		tree.insert(22);
		tree.insert(23);
		tree.insert(24);
		tree.inOrderTraversal();
		System.out.println(tree.searchElement(tree.getRoot(), 40));
		System.out.println(tree.searchElement(tree.getRoot(), 13));
		tree.delete(tree.getRoot(), 19);
		tree.delete(tree.getRoot(), 17);
		tree.inOrderTraversal();

		System.out.println(tree.isBST(tree.getRoot()));
		System.out.println(tree.isBSTInOrder());

		System.out.println("------------------------------------------");
		AugmentedBST<Integer> augTree = new AugmentedBST<>();
		augTree.insert(10);
		augTree.insert(5);
		augTree.insert(15);
		augTree.insert(3);
		augTree.insert(7);
		augTree.insert(13);
		augTree.insert(17);
		augTree.insert(16);
		augTree.insert(19);
		augTree.insert(21);
		augTree.insert(25);
		augTree.insert(20);
		augTree.insert(22);
		augTree.insert(23);
		augTree.insert(24);
		augTree.display();
		System.out.println(augTree.getKthElement(12));

		Integer arr[] = new Integer[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		BinarySearchTree<Integer> data = new BinarySearchTree<>();
		data.constructBST(arr);
		data.inOrderTraversal();
	}

}
