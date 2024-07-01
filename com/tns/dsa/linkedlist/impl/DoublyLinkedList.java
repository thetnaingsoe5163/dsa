package com.tns.dsa.linkedlist.impl;

import java.util.Iterator;

import com.tns.dsa.linkedlist.LinkedList;

public class DoublyLinkedList<T> extends LinkedList<T>{
	
	Node<T> head;
	Node<T> tail;
	
	private class Node<T> {
		T value;
		Node<T> previous;
		Node<T> next;
		
		Node(T value) {
			this.value = value;
		}
		
	}
	
	@Override
	public void insertFirst(T e) {
		if(head == null) {
			Node<T> node = new Node<T>(e);
			head = node;
			tail = node;
		} else {
			Node<T> node = new Node<T>(e);
			node.next = head;
			head.previous = node;
			head = node;
		}
		
	}

	@Override
	public void insertLast(T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T deleteFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T deleteLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
