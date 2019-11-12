

import java.util.ArrayList;
import java.util.HashMap;




public class DoubleHashMap<K,V> extends AbstractHashMap<K,V> {
    private MapEntry<K,V>[] table;        // a fixed array of entries (all initially null)
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);   //sentinel
    int collision = 0 ; 


   
    public DoubleHashMap() { super(); }

   

   
    public DoubleHashMap(int cap,float loadFactor) { super(cap, loadFactor); }

    
   
    @SuppressWarnings({"unchecked"})
    @Override
    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[this.capacity];   // safe cast
    }

   
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }


    protected V bucketGet(K key) {

		MapEntry<K,V> element = contains(key);
		String result = new String();
		if(element == null) return null;
                result += element.getMap().size() + " document(s) found.\n";
                for(HashMap.Entry<V,Integer> entry : element.getMap().entrySet()){
                    result += entry.getKey() + " " + entry.getValue() + "\n";
                    }
                
		return (V)result;
	}
    
    public int getIndex(K key) {
		
		int index = compression(key);
                int increment = 0;
		
		if(contains(key) != null) { 

			while(table[index] != null ) {
	
				if(table[index].getKey().hashCode() == key.hashCode())
					return index;
				
				index = ((index % table.length) + increment * (7 - ( index % 7 ))) % table.length ;
                                increment++;
			} 
		}
		
		return -1;
	}

    @Override
    protected int compression(K key) {
		
		int index = (key.hashCode() % table.length) ;
		if(index < 0)
			index += table.length;
		return index;
	}
    
    
   public MapEntry<K,V> contains(K key) {
		
		int index = compression(key);
		int counter = 0;
                int increment = 0;
             
		
		if(table[index] != null) {
			
			if(key.equals(table[index].getKey())) {
				
				return table[index];
			}
			else {
				
				while(table[index] != null) {
					
					if(!key.equals(table[index].getKey())) {
						
						index = (index + increment * (83 - ( index % 83 ))) % table.length ;
						counter += 1;
                                                increment++;
						
						if(counter >= table.length) {
						return null;
						}
					}
					else {
						return table[index];	
					}
                                        		
				}	
                                
			}	
		}
		return null;	
	}

    private void resize() {
		
		int newCap = newPrimeCapacity();
		MapEntry<K,V>[] temp = table;
		this.size = 0;
		table = (MapEntry<K,V>[]) new MapEntry[newCap];
        
		for(MapEntry<K,V> e : temp) {
			
			if(e != null) {
                            
                            for(V str : e.getMap().keySet()){
                                for(int i = 0 ; i < e.getMap().get(str); i++){
                                    bucketPut(e.getKey(),str);
                                   
                                }  
                            }
				
			}
		}
              
		
	}
    private int newPrimeCapacity() {
		
		int newCapacity = table.length * 2;
		boolean isPrime = false; 
		int counter = 0;
		
		do{
			for(int j = 2 ; j < newCapacity ; j++) 
				if(newCapacity % j == 0) 
					counter++;
				
			if(counter == 0) 
				isPrime = true;
			else {
				newCapacity += 1;
				counter = 0;
			}
			
		}while(!isPrime);
		
		threshold =(int)(loadFactor * newCapacity);

		return newCapacity;
	}
    
	

    protected V bucketPut(K key, V value) {
        
        MapEntry<K,V> newEntry = new MapEntry<K,V>(key, value);                         
        int index = compression(newEntry.getKey());   
        MapEntry<K,V> oldEntry = table[index];
        MapEntry<K,V> ifFound = null;
        int increment = 0 ;
        
        
        if(value == null) throw new IllegalArgumentException("Given value can not be null!");
        
        else if(oldEntry == null) {
			
			table[index] = newEntry;
			this.size += 1;
                    
	}
        else if(((ifFound = contains(key)) != null )) { // Collision detected.
			
            ifFound.update(value);
	}
        else
        {   
            while(table[index]!=null){
                index = (index + increment * (83 - ( index % 83 ))) % table.length ;
                increment++;
                collision++;
            }
            table[index] = newEntry;
            this.size += 1;
            

        }
        if(size == threshold) 
			resize();
		//System.out.println(size + " " + buckets.length + " " + threshold);
		return null;
    
    }


//   
//    protected V bucketRemove(int h, K k) {
//        int j = findEmptySlot(h, k);
//        if (j < 0) return null;                   // nothing to remove
//        V answer = table[j].getValue();
//        table[j] = DEFUNCT;                       // mark this slot as deactivated
//        n--;
//        return answer;
//    }


    @Override
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(this.capacity);
        for(Entry<K,V> element : table)
			buffer.add(element);
			
		return buffer;
	}
	
    @Override
	public V bucketSet(K key, V value) {
		
		MapEntry<K,V> element = contains(key);
		V temp = null;
		
		if(element != null) {
			temp = element.getValue();
			element.setValue(value);
		}
		
		return temp;
		
	}
        @Override
           public void printMap(){
               for(MapEntry<K,V> a : table){
                   if(a != null)
                    System.out.println(a);
               }
               System.out.println(collision);
               System.out.println(this.size);
           }
}