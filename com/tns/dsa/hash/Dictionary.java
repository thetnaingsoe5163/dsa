package com.tns.dsa.hash;

public abstract class Dictionary<K, V> {
	
	public abstract int register(K key, V value);
	
	public abstract V search(K key);
	
	public abstract int getSize();
	
	public abstract int getHashCode(K key);
}
