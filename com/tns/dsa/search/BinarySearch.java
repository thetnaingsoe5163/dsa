package com.tns.dsa.search;

public class BinarySearch extends Array implements Searchable {

	public BinarySearch(int[] arr) {
		super(arr);
	}

	@Override
	public int search(int value) {
		int[] arr = super.arr;
		int first = 0;
		int last = arr.length-1;
		
		while(first <= last) {
			int middle = (first + last) / 2;
			if(value == arr[middle]) return middle;
			else if(value > arr[middle]) {
				first = middle + 1;
			}
			else {
				last = middle - 1;
			}
		}
		
		return -1;
	}

}
