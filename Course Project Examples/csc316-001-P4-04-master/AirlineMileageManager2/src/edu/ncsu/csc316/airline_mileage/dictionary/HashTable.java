package edu.ncsu.csc316.airline_mileage.dictionary;

/**
 * A hash table which computes a value for an object based on the said objects'
 * key, and assigns the object as a value. This is all stored within an array list and
 * has separate chaining which employs a linked list of buckets for every instance of
 * the array list
 * @author Aasiyah Feisal
 *
 * I used class notes and the textbook to help me implement merge sort.
 *
 * @param <E> an abstract element to set
 */
public class HashTable<E> {
    private ArrayBasedList<Bucket<E>> array;
    private int buckets;
    private int size;
    
    /** Initial number of buckets for an instance of the array list */
    private final int initBuckets = 10;
    /** Threshold to check to see if array list should be expanded */
    private final double threshold = 0.7;
    /** Number to double size of array */
    private final int multByTwo = 2;
    
    /**
     * Creates an initially sized hash table with the same number of elements as
     * a default array list (10)
     */
    public HashTable() {
    	this.buckets = initBuckets;
    	this.size = 0;
    	this.array = new ArrayBasedList<>();
    	
    	for (int i = 0; i < buckets; i++)
            array.add(null);
    }
    
    /**
     * Retrieves the number of elements within the hash table
     * @return the size of the table
     */
    public int size() {
    	return this.size;
    }
    
    /**
     * Inserts a key-value pair into the arraylist, and expands it
     * if necessary
     * @param key the key value to set
     * @param value the element to set
     */
    public void put(String key, E value) {
        int hash = compress(key);
        Bucket<E> head = array.get(hash);
        while (head != null) {
            head = head.next;
        }
        
        Bucket<E> newNode = new Bucket<E>(key, value);
        newNode.next = array.get(hash);
        array.set(hash, newNode);
 
        size++;
        
        double sizeCheck = (double) size;
        if ((sizeCheck / buckets) >= threshold) {
        	int oldSize = size;
        	
            ArrayBasedList<Bucket<E>> temp = array;
            
            array = new ArrayBasedList<>();
            buckets *= multByTwo;
            size = 0;
            for (int i = 0; i < buckets; i++) {
                array.add(null);
            }
 
            for (int i = 0; i < oldSize; i++) {
            	Bucket<E> headNode = temp.get(i);
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    
    /**
     * Removes the head of the linked list where the key given indicates
     * @param key the key which is used to find the element to remove
     * @return the element removed
     */
    public E remove(String key) {
        int hash = compress(key);
        Bucket<E> head = array.get(hash);
 
        Bucket<E> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;

            prev = head;
            head = head.next;
        }
        
        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            array.set(hash, head.next);
 
        return head.value;
    }

    /**
     * Retrieves the element at the head of the linked list where the 
     * key given indicates
     * @param key the key which is used to find the element
     * @return the element associated with the specific key
     */
    public E get(String key) {
        int hash = compress(key);
        Bucket<E> head = array.get(hash);
        
        // Search key in chain
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
 
        // If key not found
        return null;
    }

    /**
     * Uses hash code to find an index for the value associated with
     * the given key string
     * @param key the key used to find an index
     * @return the index for the element specified by key
     */
    private int compress(String key) {
        return Math.abs(key.hashCode() % buckets);
    }

    /**
     * An instance of a Bucket used for chaining within the HashTable
     * @author Aasiyah Feisal
     *
     * @param <E> an abstract element
     */
    public static class Bucket<E> {
		String key;
        E value;
        Bucket<E> next;

        /**
         * Constructs a bucket with a key-value pair
         * @param key the key to use when hashing
         * @param value the value for the specified key
         */
        public Bucket(String key, E value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
 
 }
