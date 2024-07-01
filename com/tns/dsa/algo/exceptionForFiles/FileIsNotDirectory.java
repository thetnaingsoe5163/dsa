package com.tns.dsa.algo.exceptionForFiles;

public class FileIsNotDirectory extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FileIsNotDirectory() {
		super("Please enter real folder path!");
	}
}