package com.tns.dsa.dsaImpl.linkedList;

public class DoublyLinkedList extends LinkedList {
	
	Node head = null;
	Node tail = null;
	
	int size = 0;
	
	private static class Node {
		int data;
		Node previous = null;
		Node next = null;
		
		Node(int data) {
			this.data = data;
		}
		
		private Node getClone() {
			Node clonedNode = new Node(this.data);
			clonedNode.previous = this.previous;
			clonedNode.next = this.next;
			return clonedNode;
		}
	}
	
	// completed testing
	@Override
	public void add(int item) {
		if(head == null) {
			Node newNode = new Node(item);
			head = newNode;
			tail = newNode;
			++size;
			return;
		}
		
		if(tail == head) {
			Node newNode = new Node(item);
			tail = newNode;
			tail.previous = head;
			head.next = tail;
			++size;
			return;
		}
		
		Node temp = tail;
		Node newNode = new Node(item);
		
		tail = newNode;
		newNode.previous = temp;
		temp.next = tail;
		
//		Node headBackUp = head.getClone();
//		while(headBackUp.next != null) {
//			headBackUp = headBackUp.next;
//		}
//		if(headBackUp.previous == null & headBackUp.next == null) {
//			Node newNode = new Node(item);
//			head.next = newNode;
//			newNode.previous = head;
//			++size;
//			return;
//		}
//		Node newNode = new Node(item);
//		headBackUp.next = newNode;
//		newNode.previous = headBackUp;
		
		++size;
	}

	@Override
	public void add(int index, int item) {
		int i = 0;
		if(head == null && index == 0) {
//			Node newNode = new Node(item);
//			head = newNode;
//			tail = newNode;
//			++size;
			add(item);
			return;
		}
		
		// replacing last node
		if(index == size-1) {
			if(head == tail) {
				Node newNode = new Node(item);
				head = newNode;
				head.next = tail;
				tail.previous = head;
			}
			
			Node temp = tail.previous;
			
			Node newNode = new Node(item);
			temp.next = newNode;
			newNode.previous = temp;
			newNode.next = tail;
			tail.previous = newNode;
			++size;
			return;
		}
		
		// insert last
		if(index == size) {
			add(item);
			return;
		}
		
		// insert fast 
		Node newNode = new Node(item);
		
		Node headBackUp = head.getClone();
		Node previous = null;
		
		while(headBackUp != null) {
			if(i == index) {
				if(previous == null) {
					Node temp = head;
					Node newNode = new Node(item);
					
					head = newNode;
					head.next = temp;
					temp.previous = head;
					
					++size;
					return;
				}
				
				if(i == 1) {
					Node temp = headBackUp;
					Node newNode = new Node(item);
					
					head.next = newNode;
					
					newNode.previous = head;
					newNode.next = temp;
					
					temp.previous = newNode;
					++size;
					return;
				}
				Node newNode = new Node(item);
				Node temp = headBackUp;
				
				previous.next = newNode;
				newNode.previous = previous;
				newNode.next = temp;
				
				temp.previous = newNode;
				
				++size;
				return;
			}
			previous = headBackUp;
			headBackUp = headBackUp.next;
			i++;
		}
		 
		if(index == size) {
			Node newNode = new Node(item);
			previous.next = newNode;
			newNode.previous = previous;
		}
	}

	@Override
	public int get() {
		if(head == null) return -1;
		
		Node headBackUp = head.getClone();
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
		}
		return headBackUp.data;		
	}
	
	// completed testing
	@Override
	public int getWithIndex(int index) {
		int i = 0;
		if(head == null) return -1;
		Node headBackUp = head.getClone();
		while(headBackUp != null) {
			if(i == index) return headBackUp.data;
			headBackUp = headBackUp.next;
			i++;
		}
		return -1;
	}
	
	@Override
	public int getWithItem(int item) {
		return 0;
	}

	@Override
	public int peekNextWithIndex(int index) {
		int i = 0;
		if(head == null) return -1;
		Node headBackUp = head.getClone();
		while(headBackUp != null) {
			if(i == index) {
				int result = headBackUp.next != null ? headBackUp.next.data : -1;
				return result;
			}
			headBackUp = headBackUp.next;
			i++;
		}
		return -1;
	}
	
	@Override
	public int peekNextWithItem(int item) {
		return 0;
	}
	
	@Override
	public int peekPrevious() {
		if(head==null) return -1;
		
		Node headBackUp = head.getClone();
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
		}
		
		return headBackUp.previous == null ? -1 : headBackUp.previous.data;
	}
	
	@Override
	public int peekPreviousWithIndex(int index) {
		int i = 0;
		if(head == null) return -1;
		Node headBackUp = head.getClone();
		while(headBackUp != null) {
			if(i == index) {
				int result = headBackUp.previous != null ? headBackUp.previous.data : -1;
				return result;
			}
			headBackUp = headBackUp.next;
			i++;
		}
		return -1;
	}
	
	@Override
	public int peekPreviousWithItem(int item) {
		return 0;
	}
	
	@Override
	public int removeWithItem(int item) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removeWithIndex(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void iterate() {
		System.out.println("Node");
		if(head == null) return; 
		Node headBackUp = head.getClone();
		while(headBackUp != null) {
			int previous = headBackUp.previous == null ? -1 : headBackUp.previous.data;
			int current = headBackUp.data;
			int next = headBackUp.next == null ? -1 : headBackUp.next.data;
			System.out.printf("Previous: %s\tCurrent: %s\tNext: %s%n", previous, headBackUp.data, next);
			headBackUp = headBackUp.next;
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

}
