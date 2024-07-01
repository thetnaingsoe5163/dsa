package com.tns.dsa.sorting;

public class Bubble implements Sortable {

	@Override
	public int[] sortArray(int[] arr) {
		int length = arr.length;
		for(int i = 0; i < length-1; i++) {
			for(int j = 0; j < length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

}
