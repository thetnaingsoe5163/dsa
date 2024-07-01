package com.tns.dsa.linkedlist.impl;

import java.util.Iterator;

import com.tns.dsa.linkedlist.LinkedList;

public class SinglyLinkedList<E> extends LinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	private class Node<E> {
		
		private E value;
		private Node next;
		
		private Node(E value) {
			this.value = value;
		}
	}
	
	@Override
	public void insertFirst(E e) {
		if(head == null && tail == null) {
			head = new Node<E>(e);
			size++;
		} else if(head != null && tail == null) {
			Node temp = head;
			head = new Node<E>(e);
			tail = temp;
			head.next = tail;
			size++;
		} else {
			Node temp = head;
			head = new Node<E>(e);
			head.next = temp;
			size++;
		}
	}

	@Override
	public void insertLast(E e) {
		if(head == null & tail == null) {
			Node n = new Node<E>(e);
			head = n;
			head.next = tail;
			size++;
		} 
		// which is there is only one node
		else if(head.next == null && tail == null) {
			tail = new Node<E>(e);
			head.next = tail;
			size++;
		}
		else {
			Node temp = tail;
			tail = new Node<E>(e);
			temp.next = tail;
			size++;
		}
	}

	@Override
	public E getFirst() {
		if(head == null && tail == null) {
			return null;
		}
		return head.value;
	}

	@Override
	public E getLast() {
		if(head == null && tail == null) {
			return null;
		} else if(head != null && tail == null){
			return head.value;
		} else {
			return tail.value;
		}
	}

	@Override
	public E deleteFirst() {
		if(size == 0) {
			return null;
		}
		else if(size == 1) {
			E temp = head.value;
			head = null;
			size--;
			return temp;
		}
		else if(size == 2){
			E temp = head.value;
			head = tail;
			tail = null;
			size--;
			return temp;
		}
		else {
			E temp = head.value;
			head = head.next;
			size--;
			return temp;
		}
	}

	@Override
	public E deleteLast() {
		if(size == 0) {
			return null;
		}
		else if(size == 1) {
			E temp = head.value;
			head = null;
			size--;
			show();
			return temp;
		}
		else if(size == 2) {
			E temp = tail.value;
			tail = null;
			head.next = null;
			size--;
			return temp;
		}
		else {
			Node previous = null;
			Node current = head;
			while(current.next != null) {
				previous = current;
				current = current.next;
			}
			E temp = (E)current.value;
			tail = previous;
			tail.next = null;
			size--;
			return temp;
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}
	
	private class SinglyLinkedListIterator implements Iterator<E> {
		
		Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(current == null) return null;
			Node temp = current;
			current = current.next;
			
			return (E)temp.value;
		}
		
	}
	
	@Override
	public void show() {
		Node current = head;
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}

}
