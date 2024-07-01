package com.tns.dsa.sorting;

public class Insertion implements Sortable {

	@Override
	public int[] sortArray(int[] arr) {
		int length = arr.length;
		for(int i = 1; i < length; i++) {
			int j = i - 1;
			
			while( j >= 0 && arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		return arr;
	}

}
