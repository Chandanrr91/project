package com.ds.util;

import java.lang.reflect.Array;

import com.ds.util.bean.Node;

public class SortDataSet<T extends Comparable<T>> {

	public T[] bubbleSort(T[] arr) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					swap(arr, j, j + 1);
				}
			}
		}
		System.out.println("Bubble sort : " + (System.currentTimeMillis() - time));
		return arr;
	}

	public T[] selectionSort(T[] arr) {

		long time = System.currentTimeMillis();
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min].compareTo(arr[j]) > 0) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr, i, min);
			}
		}
		System.out.println("Selection sort : " + (System.currentTimeMillis() - time));
		return arr;
	}

	private void swap(T[] arr, int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	private int partition(T[] array, int low, int high) {

		T pivot = array[low];
		int left = low;
		int right = high;
		while (right > left) {
			while (pivot.compareTo(array[left]) >= 0 && right > left) {
				left++;
			}
			while (pivot.compareTo(array[right]) < 0) {
				right--;
			}
			if (right > left) {
				swap(array, left, right);
			}
		}
		swap(array, low, right);
		return right;
	}

	public void quickSort(T[] array, int low, int high) {

		if (low >= high) {
			return;
		} else {
			int pivot = partition(array, low, high);
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}

	private void merge(T[] input, int low, int mid, int high) {

		int i = low, j = mid + 1, k = low;
		T[] output = null;
		if (input[0] instanceof Integer) {
			output = (T[]) new Integer[input.length];
		}
		while (i <= mid && j <= high) {

			if (input[i].compareTo(input[j]) < 0) {
				output[k++] = input[i++];
			} else {
				output[k++] = input[j++];
			}
		}

		while (i <= mid) {
			output[k++] = input[i++];
		}

		while (j <= high) {
			output[k++] = input[j++];
		}

		for (int l = low; l <= high; l++) {
			input[l] = output[l];

		}
		return;
	}

	private void mergeSort(T[] input, int low, int high) {

		if (low >= high) {
			return;
		} else {
			int mid = (low + high) >> 1;
			mergeSort(input, low, mid);
			mergeSort(input, mid + 1, high);
			merge(input, low, mid, high);
		}
	}

	public T[] mergeSort(T[] input) {

		mergeSort(input, 0, input.length - 1);
		return input;

	}

}
