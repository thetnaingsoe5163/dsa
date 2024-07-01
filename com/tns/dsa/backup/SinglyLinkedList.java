package com.tns.dsa.backup;

import com.tns.dsa.dsaImpl.linkedList.LinkedList;

public class SinglyLinkedList extends LinkedList {
	
	/*
	 * In these method, I used headBackUp with can be obtained by cloning head obj which is the head of the 
	 * SinglyLinkedList but it is not the object that holds data. It is more like starting point of the SinglyLinkedList
	 * 
	 * The reason of using headBackUp is to iterate not only once but also frequently. It's like the object to iterate 
	 * through the entire linkedlist.
	 * 
	 * if we use head itself instead of using headBackUp, we can iterate once because next object will replace head object. 
	 * head is the main object to iterate through entire linkedlist as it holds next item. So, we maintain the original state
	 * of head object.
	 * 
	 * In this case, we have to be careful insertion or deletion node between head object and the next object which mean insertion at index 0
	 * we also need to change the state of head object.
	 * 
	 * In node, index -1 means head.
	 *
	 */
	
	Node head;
	int size = 0;
	
	public SinglyLinkedList() {
		head = new Node();
		head.isHead = true;
	}
	
	private static class Node {
		
		private int data;
		private Node next;
		boolean isHead = false;
		int index = -1;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
		
		Node() {
			
		}
		
		private Node getClone() {
			Node clonedNode = new Node();
			clonedNode.data = this.data;
			clonedNode.next = this.next;
			clonedNode.isHead = this.isHead;
			return clonedNode;
		}
		
	}
	
	@Override
	public void add(int item) {
		Node newNode = new Node(item);
		if(head.next == null) {
			head.next = newNode;
			//using ++head.index will affect on head obj
			newNode.index = head.index+1;
			++size;
		} else {
			Node headBackUp = head.getClone();
			while(headBackUp.next != null) {
				headBackUp = headBackUp.next;				
			}
			headBackUp.next = newNode;
			newNode.index = headBackUp.index+1;
			++size;
		}
		

	}

	@Override
	public void add(int index, int item) {
		Node headBackUp = head.getClone();
		if(headBackUp.next == null) {
			Node newNode = new Node(item);
			head.next = newNode;
			arrangeIndex();
			++size;
			return;
		}
		while(headBackUp.next != null) {
			Node previous = headBackUp;
			headBackUp = headBackUp.next;
			
			if(headBackUp.index == index) {
				if(headBackUp.index == 0) {
					Node node = new Node(item);
					head.next = node;
					node.next = headBackUp;
					arrangeIndex();
					++size;
					return;
				}
				Node node = new Node(item);
				previous.next = node;
				node.next = headBackUp;
				arrangeIndex();
				++size;
				return;
			}
		}
		Node newNode = new Node(item);
		headBackUp.next = newNode; 
		arrangeIndex();
		++size;
	}

	@Override
	public int get() {
		Node headBackUp = head.getClone();
		if(headBackUp.next == null) return -1;
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
		}
		return headBackUp.data;

	}

	@Override
	public int getWithIndex(int index) {
		Node headBackup = head.getClone();
		while(headBackup.next != null) {
			headBackup = headBackup.next;
			if(headBackup.index == index) {
				return headBackup.data;
			}
		}
		return -1;
	}
	
	@Override
	public int getWithItem(int item) {
		Node headBackUp = head.getClone();
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
			if(headBackUp.data == item) return headBackUp.data;
		}
		return -1;
	}
	
	@Override
	public int peekNextWithIndex(int index) {
		Node headBackUp = head.getClone();
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
			if(headBackUp.index == index) {
				return headBackUp.next != null ? headBackUp.next.data : -1;
			}
		}
		return -1;
	}
	
	@Override
	public int peekNextWithItem(int item) {
		Node nodeToBePeedkedNext = null;
		Node headBackup = head.getClone();
		while(headBackup.next != null) {
			headBackup = headBackup.next;
			if(headBackup.data == item) {
				nodeToBePeedkedNext = headBackup;
			}
		}
		if(nodeToBePeedkedNext == null) return -1;
		if(nodeToBePeedkedNext.next != null) {
			return nodeToBePeedkedNext.next.data;
		}
		return -1;
	}
	
	@Override
	public int remove() {
		int data = -1;
		Node headBackUp = head.getClone();
		if(headBackUp.next == null) return data;
		Node previous = null;
		
		while(headBackUp.next != null) {
			previous = headBackUp;
			headBackUp = headBackUp.next;
		}
		if(previous.isHead) {
			data = headBackUp.data;
			head.next = null;
			--size;
			return data;
		}
		data = headBackUp.data;
		previous.next = null;
		--size;
		return data; 
	}
	@Override
	public int removeWithItem(int item) {
		int data = -1;
		Node headBackUp = head.getClone();
		
		while(headBackUp.next != null) {
			Node previous = headBackUp;
			headBackUp = headBackUp.next;
			/*
			 * There are two conditions. Having found at the end and in the middle
			 */
			if(headBackUp.data == item) {
				/*
				 *  Having found at the end. There are also Two conditions 
				 *  node can be at the end but there are node in front of the found node and 
				 *  node can be at the end there is only head in front of the node
				 *  So, we used headBackUp. We need to update head status if we want to delete the last node
				 */
				if(headBackUp.next == null) {
					// node found at the end there is only head in front of the node
					if(previous.isHead) {
						data = headBackUp.data;
						head.next = null;
						arrangeIndex();
						--size;
						return data;
					}
					// node found at the end but there are node in front of the found node and 
					data = headBackUp.data;
					previous.next = null;
					arrangeIndex();
					--size;
					return data;
				} 
				// Having found in the middle
				else {
					data = headBackUp.data;
					if(previous.isHead) {
						head.next = headBackUp.next;
						arrangeIndex();
						--size;
						return data;
					}
					previous.next = headBackUp.next;
					arrangeIndex();
					--size;
					return data;
				}
			}
		}
		return data;
	}
	
	@Override
	public int removeWithIndex(int index) {
		int data = -1;
		Node headBackUp = head.getClone();
		while(headBackUp.next != null) {
			Node previous = headBackUp;
			headBackUp = headBackUp.next;
			
			if(headBackUp.index == index) {
				
				// Deleting the first Node which is after the head node
				if(headBackUp.index == 0) {
					// Data node is one
					if(headBackUp.next == null) {
						data = headBackUp.data;
						head.next = null;
						arrangeIndex();
						size--;
						return data;
					}
					// Data node is two
					else {
						data = headBackUp.data;
						head.next = headBackUp.next;
						arrangeIndex();
						size--;
						return data;
					}
				}
				
				
				// Deleting the last node
				if(headBackUp.next == null) {
					data = headBackUp.data;
					previous.next = null;
					arrangeIndex();
					size--;
					return data;
				}
				
				// Deleting the middle
				data = headBackUp.data;
				previous.next = headBackUp.next;
				arrangeIndex();
				size--;
				return data;
			}
		}
		
		// Not found 
		return data;
		
	}
	

	@Override
	public void clear() {
		head.next = null;
		size = 0;
	}

	@Override
	public void iterate() {
		System.out.println("Node ");
		Node headBackUp = head.getClone();
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
			System.out.println("Index "+ headBackUp.index+ " : " +headBackUp.data + ", ");
			
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	// Methods not support
	
	@Override
	public int peekPreviousWithItem(int item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int peekPrevious() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int peekPreviousWithIndex(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// custom methods for singly linkedList
	void arrangeIndex() {
		Node headBackUp = head.getClone();
		int i = headBackUp.index;
		while(headBackUp.next != null) {
			headBackUp = headBackUp.next;
			headBackUp.index = ++i;
		}
	}
}
