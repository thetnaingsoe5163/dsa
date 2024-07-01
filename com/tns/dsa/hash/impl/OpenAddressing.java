package com.tns.dsa.hash.impl;

import com.tns.dsa.hash.Dictionary;

public class OpenAddressing<K, V> extends Dictionary<K, V> {
	
	private Entry[] entries;
	private int capacity;
	private int size;
	
	public OpenAddressing(int capacity) {
		this.entries = (Entry<K, V>[])new Entry[capacity];
		this.capacity = capacity;
	}
	
	private class Entry<K, V> {
		
		private K key;
		private V value;
		
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	@Override
	public int register(K key, V value) {
		if(size < capacity) {
			int index = getHashCode(key);
			var entry = entries[index];
			if(entry == null) {
				entries[index] = new Entry<>(key, value);
				++size;
				return index;
			}
			else {
				index = getNextIndex(index);
				while(true) {
					entry = entries[index];
					if(entry == null) {
						entries[index] = new Entry<>(key, value);
						++size;
						return index;
					}
					index = getNextIndex(index);
				}
			}
		}
		return -1;
	}

	@Override
	public V search(K key) {
		int index = getHashCode(key);
		var entry = entries[index];
		if(entry.key.equals(key)) {
			return (V)entry.value;
		}
		else {
			int originalIndex = index;
			index = getNextIndex(index);
			while(originalIndex != index) {
				entry = entries[index];
				if(entry.key.equals(key)) {
					return (V) entry.value;
				}
				index = getNextIndex(index);
			}
			return null;
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public int getHashCode(K key) {
		return Math.abs((key.hashCode()) % capacity);
	}
	
	private int getNextIndex(int index) {
		return (index + 1) % capacity;
	}

}
