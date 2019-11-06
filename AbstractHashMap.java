
package hashtable;



public abstract class AbstractHashMap<K,V> implements Map<K,V> {

	private static final int DEFAULT_CAPACITY = 11;
	private static final float DEFAULT_LOADFACTOR = 0.7f;
	protected float loadFactor;
	protected int threshold;
	protected int size;
	protected int capacity;
       
     

	
	public AbstractHashMap(int capacity, float loadFactor) {
		
		if(capacity <= 0) throw new IllegalArgumentException("Capacity must be bigger than zero.");
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		threshold = (int) (capacity * loadFactor);
		createTable();
		
	}
	
	
	public AbstractHashMap() {
		
		this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
	}
	
	
	@Override
	public int size() {
		
		return this.size;
	}
	
	
	@Override
	public V get(K key) {
		
		return bucketGet(key);
	}
	
	
	
	@Override
	public V put(K key, V value) {
		
		return bucketPut(key, value);

	}
	
	
	@Override
	public V set(K key, V value) {
		
		return bucketSet(key, value);

	}
	
	
	@Override
	public boolean isEmpty() {
		
		return size() == 0;
	}
	


	
	protected abstract void createTable();
	
	protected abstract V bucketGet(K key);
	
	protected abstract V bucketPut(K key, V value);
	
	protected abstract V bucketSet(K key, V value);
	
	protected abstract int compression(K key);
        
        public abstract void printMap();

  
	
}