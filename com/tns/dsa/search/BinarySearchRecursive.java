package com.tns.dsa.search;

public class BinarySearchRecursive extends BinarySearch implements Searchable {

	public BinarySearchRecursive(int[] arr) {
		super(arr);
	}

	@Override
	public int search(int value) {
		return recursiveSearch(value, 0, arr.length-1);
	}
	
	int recursiveSearch(int value, int start, int end) {
		int[] arr = super.arr;
		
		/*
		 * start > end means no value found in arr so return -1 which mean not found
		 * if arr is empty, also return -1;
		 */
		if(start > end || arr.length == 0) return -1;
		
		/*
		 * find middle and if value found, return the index which is middle;
		 */
		int middle = (start + end) / 2;
		if(arr[middle] == value) { 
			return middle;
		} 
		/*
		 * value is on the left side of arr
		 * so update the end and do recursive
		 */
		else if(value < arr[middle]) {
			return recursiveSearch(value, start, middle-1);
		}
		/*
		 * value is on the right side of arr
		 * so update the start and do recursive
		 */
		else {
			return recursiveSearch(value, middle+1, end);
		}
	}
}
