/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author KRGZ
 */
public interface Entry<K,V> {
	
	/**
	 * @return key of entry.
	 */
	K getKey();
	/**
	 * @return value of entry.
	 */
	V getValue();
	/**
	 * @return count of entry that shows the collision number.
	 */
      
	
}
