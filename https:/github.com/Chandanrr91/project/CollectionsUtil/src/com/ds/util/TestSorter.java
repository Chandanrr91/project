package com.ds.util;

public class TestSorter {

	public static void main(String[] args) {
		Integer[] array = new Integer[50];
		Integer[] array2 = new Integer[50];
		Integer[] array3 = new Integer[50]; // { 6, 10, 34, 2, 35, 12, 42, 63, 1, 4, 15, 18, 12 };
		Integer[] array4 = new Integer[50];
		for (int i = 0; i < array.length; i++) {
			array[i] = array.length - i;
			array2[i] = array2.length - i;
			array3[i] = array3.length - i;
			array4[i] = array4.length - i;
			System.out.print(array[i] + "-");
		}
		SortDataSet<Integer> sorter = new SortDataSet<>();
		Integer[] result = sorter.bubbleSort(array);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ",");
		}

		Integer[] result2 = sorter.selectionSort(array2);
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + ",");
		}

		System.out.println();
		long time = System.currentTimeMillis();
		sorter.quickSort(array3, 0, array3.length - 1);
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + ",");
		}
		System.out.println("Quick sort:" + (System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		Integer[] output = sorter.mergeSort(array4);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + ",");
		}
		System.out.println("Merge sort:" + (System.currentTimeMillis() - time));
	}

}
