package com.tns.dsa.linkedlist;

import java.util.Iterator;

public abstract class LinkedList<E> {
	
	public abstract void insertFirst(E e);
	
	public abstract void insertLast(E e);
	
	public abstract E getFirst();
	
	public abstract E getLast();
	
	public abstract E deleteFirst();
	
	public abstract E deleteLast();
	
	public abstract int size();
	
	public abstract Iterator<E> iterator();
	
	public abstract void show();
	
}
