package com.tns.dsa.search;

public class LinearSearch extends Array implements Searchable {

	public LinearSearch(int[] arr) {
		super(arr);
	}

	@Override
	public int search(int value) {
		int length = super.arr.length;
		for(int i = 0; i < length; i++) {
			if(super.arr[i] == value) return i; 
		}
		return -1;
	}
	
}
