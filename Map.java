/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;


public interface Map<K,V> {

	/**
	 * Returns the value of key. If key is not found, returns null.
	 * @param key key will be searched.
	 * @return Value value of found key.
	 */
	V get(K key);
		
	/**
	 * Sets the new value to given key.
	 * @param key key of entry will be updated.
	 * @param value new value of entry.
	 * @return old value of entry that has given key.
	 */
	V set(K key, V value);

	/**
	 * Inserts new entry into the map: 
	 * If key is not already in map, then return null.
	 * else, return old value associated with key and increase the count value of key.
	 * @param key key of new entry.
	 * @param value value of new entry.
	 * @return old value of key.
	 */
	V put(K key, V value);
	
	/**
	 * If the map has an entry with key, returns its index;
	 * @param key key will be searched.
	 * @return index of found key.
	 */
	int getIndex(K key);
	
	
	/**
	 * @return size of map.
	 */
	int size();
	
	/**
	 * @return emptiness of map.
 	 */
	boolean isEmpty();


	/**
	 * @return iterable collection of entry set.
	 */
	Iterable<Entry<K,V>> entrySet();
		
	
	
}