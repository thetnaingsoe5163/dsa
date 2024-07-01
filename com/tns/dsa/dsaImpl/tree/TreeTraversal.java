package com.tns.dsa.dsaImpl.tree;

import java.util.Stack;

public class TreeTraversal {
	
	public void preOrder(Node node) {
		if(node == null) {
			System.out.println("No Data");
			return;
		}
		System.out.print(node + " ");
		for(int i = 0; i < node.childNodes.size(); i++) {
			preOrder(node.childNodes.get(i));
		}
	}
	
	public void preOrderIterative(Node node) {
		if(node == null) {
			System.out.print("No data");
			return;
		}
		
		Stack<Node> stack = new Stack();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			Node parent = stack.pop();
			System.out.print(parent + " ");
			for(int i = parent.childNodes.size()-1; i >= 0; i--) {
				stack.push(parent.childNodes.get(i));
			}
		}
	}
	
	public void inOrder(Node node, Node parent) {
		if(node.childNodes.isEmpty() && parent != null) {
			System.out.print(node + " " + parent+ " ");
		}
		else if(node.childNodes.isEmpty() && parent == null) {
			System.out.print(node + " ");
		}
		for(int i = 0; i < node.childNodes.size(); i++) {
			inOrder(node.childNodes.get(i), node);
		}
	}
	
	public void postOrder(Node node) {
		if(node.childNodes.size() == 0) {
			System.out.print(node + " ");
		}
		for(int i = 0; i < node.childNodes.size(); i++) {
			postOrder(node.childNodes.get(i));
		}
		System.out.print(node + " ");
	}
}
