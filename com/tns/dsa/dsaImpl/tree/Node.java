package com.tns.dsa.dsaImpl.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	char value;
	List<Node> childNodes = new ArrayList();
	
	public Node(char value) {
		this.value = value;
	}
	
	public void addChild(Node node) {
		this.childNodes.add(node);
	}
	
	@Override
	public String toString() {
		return Character.toString(this.value);
	}
}
