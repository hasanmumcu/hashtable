/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;


import java.util.HashMap;



/**
 *
 * @author KRGZ
 */
public class MapEntry<K,V> implements Entry<K,V>{

	private K key;
	private V value;

        private HashMap <V, Integer> test;

	
	
	public MapEntry(K key, V value) {
		this.test = new HashMap  <V, Integer> ();
		this.key = key;
		this.value = value;
		update(value);
                

	}
        public MapEntry(){super();}
        public void update(V value){
            if(test.containsKey(value))
                test.put(value, test.get(value) + 1 );
            else
                test.put(value , 1);
        }
	
	/**
	 * @return count number of entry.
	 */
	
	/**
	 * @return key of entry.
	 */
	@Override
	public K getKey() {
		return this.key;
	}
	
	/**
	 * @return value of entry.
	 */
	@Override
	public V getValue() {
		return this.value;
	}
	
	/**
	 * @param key new key of entry.
	 */
	protected void setKey(K key) {
		
		this.key = key;
	}
	
	/**
	 * Sets the new value of entry and returns the old value.
	 * @param value new value of entry.
	 * @return old value of entry.
	 */
	protected V setValue(V value) {
		
		V old = this.value;
		this.value = value;
		return old;
	}
	
	/**
	 * @param count number of entry.
	 */

	/**
	 * Increases the count value by 1. 
	 */
	
	
	/**
	 * @return the hash code of key of entry.
	 */
        public HashMap<V, Integer> getMap(){
            return this.test;
            
        }
        
        
	@Override
	public int hashCode() {
		
		return this.key.hashCode();
	}
        
        public String toString(){
            return this.key + " " + " " + this.value  + " " + this.test + " " + (this.hashCode() % 11);
            
        }
         
      
}