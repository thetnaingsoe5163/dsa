package com.tns.dsa.utility;

import java.util.ArrayList;

public class General {
	
	public static int factorial(int num) {
		if(num == 0) {
			return 1;
		}
		return num * factorial(num-1);
	}
	
	public static boolean uniqueData(ArrayList<String> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = i+1; j < list.size(); j++) {
				if(list.get(i).equals(list.get(j))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void output(ArrayList<String> s) {
		System.out.println("Size " + s.size());
		for(var a : s) {
			System.out.println(a);
		}
	}
}
