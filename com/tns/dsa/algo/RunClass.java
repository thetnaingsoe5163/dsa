package com.tns.dsa.algo;

public class RunClass {
	
	public static void main(String[] args) {
		FileFinder f = new FileFinder();
		var list = f.findFile("C:\\Users\\hp\\Desktop\\Test1", "t.txt");
		System.out.println(null == list);
		if(list != null) {
			list.forEach(a -> System.out.println(a));
		}
	}
}
