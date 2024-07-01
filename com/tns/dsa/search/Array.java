package com.tns.dsa.search;

public class Array {
	
	int size;
	protected int[] arr;
	
	public Array(int[] arr) {
		this.arr = arr;
		size = arr.length;
	}
	
	public Array(int size) {
		this.size = size; 
		arr = new int[size];
	}
	
	public void put(int index, int value) {
		arr[index] = value;
	}
	
	public int get(int index) {
		return arr[index];
	}
}
