package com.tns.dsa.utility;

import java.util.Random;

public class ArrayUtility {
	
	public static boolean isArraySorted(int[] arr) {
		boolean ascending = false;
		if(arr.length == 0) return false;
		else if(arr.length == 1) return true;
		else if(arr[0] < arr[1]) ascending = true;
		for(int i = 0; i < arr.length-1; i++) {
			if(ascending) {
				if(arr[i] > arr[i+1]) return false;
			} else {
				if(arr[i] < arr[i+1]) return false;
			}
		}
		return true;
	}
	
	public static int[] randomDataIntArray(int range, int room) {
		Random random = new Random();
		int[] arr = new int[room];
		int arrLength = arr.length;
		for(int i = 0; i < arrLength; i++) {
			arr[i] = random.nextInt(0, range+1);
		}
		return arr;
	}
	
	public static void print(int[] arr, String message) {
		int length = arr.length;
		System.out.print(message + " { ");
		for(int i = 0; i < length; i++) {
			if(i == length-1) System.out.print(arr[i]);
			else System.out.print(arr[i] + ", ");
		}
		System.out.print(" }");
		System.out.println("");
	}
}
