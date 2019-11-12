

public class Key {

	private String key;
	private int hash; 
        public static enum HashMethod{
            SSF,
            PAF
        };
        private HashMethod hashMethod;
	
	/**
	 * Creates new Key with given string key.
	 
         * @param key value of Key.
	 */
	public Key(String key) {
		
		this.key = key;
                this.hashMethod = hashMethod.SSF;
	}
        
        public Key(String key, HashMethod hashMethod){
        
            this.key = key;
            this.hashMethod = hashMethod;
        }

  
	
	/**
	 * Calculates and returns the hash code of string key.
	 * @return hash code of string key.
	 */
	@Override 
	public int hashCode() {
            int h = hash;
			
		if(h == 0 && key.length() > 0) {
                    if(this.hashMethod == HashMethod.SSF){
				
			char value[] = key.toCharArray();
				
			for(int i = 0 ; i < value.length; i++) {
					
				h = h + (value[i]-96);
                             
                                
			}
                    }
                    else{
                        
                    	char value[] = key.toCharArray();
                        
				
			for(int i = 0 ; i < value.length; i++) {
					
				h = h + (value[i]-96)* (int)Math.pow(33, value.length-i-1);  
                                
                                
			}
//			
  
                    }
	
			hash = h;
                        
		}
		return h;
	}
  

	@Override
	public String toString() {
		
		return this.key;
	}
        
        @Override
        public boolean equals(Object key){
          
            return this.key.equals(key.toString());
        }
	
}
