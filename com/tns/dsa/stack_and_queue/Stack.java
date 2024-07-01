package com.tns.dsa.stack_and_queue;

public interface Stack<E> {
	
	void push(E e);
	
	E pop();
	
	E peek();
	
	boolean isEmpty();
	
	int getSize();
}
