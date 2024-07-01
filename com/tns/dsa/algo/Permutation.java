package com.tns.dsa.algo;

import java.util.ArrayList;

public class Permutation {
	
	private ArrayList<String> result;
	
	public Permutation() {
		result = new ArrayList<>();
	}
	
	public ArrayList<String> permute(String word, int index) {
		StringBuilder sb = new StringBuilder(word);
		if(index == word.length()-2) {
			var leaves = getChildSwappedValues(sb, index);
			for(var l : leaves) {
				result.add(l.toString());
			}
			return result;
		}
		var childs = getChildSwappedValues(sb, index);
		
		for(var c : childs) {
			permute(c.toString(), index+1);
		}
		
		return result;
	}
	
	public ArrayList<StringBuilder> getChildSwappedValues(StringBuilder word, int index) {
		ArrayList<StringBuilder> swapped = new ArrayList<>();
		for(int i = index; i < word.length(); i++) {
			swapped.add(swap(word, index, i));			
		}
		return swapped;
	}
	
	public StringBuilder swap(StringBuilder word, int a, int b) {
		StringBuilder sb = new StringBuilder(word);
		char temp = word.charAt(a);
		sb.replace(a, a+1, Character.toString(word.charAt(b)));
		sb.replace(b, b+1, Character.toString(temp));
		return sb;
	}
	
}
