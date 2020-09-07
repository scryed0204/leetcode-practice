package com.liamtang.otherpractice.hashtable;

/**
 * A node of chains 
 * @author toshiba1
 *
 * @param <K>
 * @param <V>
 */
public class HashNode<K, V> {
	
	K key;
	V value;
	
	// Reference to next node 
	HashNode<K,V> next;
	
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
