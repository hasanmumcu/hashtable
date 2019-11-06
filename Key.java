
package hashtable;
public class Key {

	private String key;
	private int hash; 
	
	/**
	 * Creates new Key with given string key.
	 
         * @param key value of Key.
	 */
	public Key(String key) {
		
		this.key = key;
	}

  
	
	/**
	 * Calculates and returns the hash code of string key.
	 * @return hash code of string key.
	 */
	@Override 
	public int hashCode() {
		
		int h = hash;
			
		if(h == 0 && key.length() > 0) {
				
			char value[] = key.toCharArray();
				
			for(int i = 0 ; i < value.length; i++) {
					
				h = h + (value[i]-96);
                             
                                
			}
			
			hash = h;
		}
		return h;
	}
	
	/**
	 * @return value of key.
	 */
	@Override
	public String toString() {
		
		return this.key;
	}
        
        @Override
        public boolean equals(Object key){
          
            return this.key.equals(key.toString());
        }
	
}
