// Not finished. In progress!
package com.tns.dsa.sorting;

import java.util.ArrayList;

public class QuickSort implements Sortable {

	@Override
	public int[] sortArray(int[] arr) {
		return quickSort(arr, 0, arr.length-1);
	}
	
	int[] quickSort(int[] arr, int startIndex, int endIndex) {
		
		int size = endIndex-startIndex+1;
				
		if(size >= 3) {
			// divide
			int pivot = arr[endIndex];
			
			ArrayList<Integer> left = new ArrayList();
			ArrayList<Integer> right = new ArrayList();
			
			for(int i = startIndex; i < endIndex; i++) {
				
				if(arr[i] <= pivot) {
					left.add(arr[i]);
				} else {
					right.add(arr[i]);
				}
			}
			
			int index = startIndex;
			for(Integer l : left) {
				arr[index++] = l;
			}
			
			int leftEndIndex = index-1;
			arr[index++] = pivot;
			int rightStartIndex = index;
			
			for(Integer r : right) {
				arr[index++] = r;
			}
			
			quickSort(arr, 0, leftEndIndex);
			quickSort(arr, rightStartIndex, arr.length-1);
			
		} else {
			
			if(size == 2) {
				if(arr[startIndex] > arr[endIndex]) {
					int temp = arr[startIndex];
					arr[startIndex] = arr[endIndex];
					arr[endIndex] = temp;
				}
			}
		}
		
		return arr;
	}

}
