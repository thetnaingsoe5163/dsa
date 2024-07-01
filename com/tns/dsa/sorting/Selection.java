package com.tns.dsa.sorting;

public class Selection implements Sortable {

	@Override
	public int[] sortArray(int[] arr) {
		int length = arr.length;
		for(int i = 0; i < length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j < length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
	
	
}
