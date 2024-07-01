package com.tns.dsa.dsaImpl.linkedList;

public abstract class LinkedList {
	
	// Add Section
	public abstract void add(int item);
	
	public abstract void add(int index, int item);
	
	// Get Section
	public abstract int get();
	
	public abstract int getWithIndex(int index);
	
	public abstract int getWithItem(int item);
	
	// Peek Next section
	
	public abstract int peekNextWithIndex(int index);
	
	public abstract int peekNextWithItem(int item);
	
	// Peek previous Section
	public abstract int peekPrevious();
	
	public abstract int peekPreviousWithIndex(int index);
	
	public abstract int peekPreviousWithItem(int item);
	
	// Remove Section
	public abstract int remove();
	
	public abstract int removeWithItem(int item);
	
	public abstract int removeWithIndex(int index);
	
	public abstract void clear();
	
	// General Section
	public abstract void iterate();
	
	public abstract int getSize();
}
