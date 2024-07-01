package com.tns.dsa.stack_and_queue.impl;

import com.tns.dsa.linkedlist.impl.SinglyLinkedList;
import com.tns.dsa.stack_and_queue.Stack;

public class StackImpl<E> extends SinglyLinkedList<E> implements Stack<E> {

	@Override
	public void push(E e) {
		super.insertLast(e);
	}

	@Override
	public E pop() {
		return super.deleteLast();
	}

	@Override
	public int getSize() {
		return super.size();
	}

	@Override
	public E peek() {
		return super.getLast();
	}

	@Override
	public boolean isEmpty() {
		return super.size() == 0;
	}


}
