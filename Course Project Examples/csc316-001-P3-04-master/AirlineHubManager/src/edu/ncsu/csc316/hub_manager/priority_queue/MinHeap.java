package edu.ncsu.csc316.hub_manager.priority_queue;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.priority_queue.Item;

/**
 * Creates a MinHeap of abstract elements
 * @author Aasiyah Feisal
 *
 * @param <E> allows abstract elements to be used
 */
public class MinHeap<E> {
	/** List of item objects within heap */
    private Item[] heap;
    /** Size of heap */
    private int size;
 
    /** Keeps track of the first element within the heap */
    private static final int FIRST = 1;
 
    /**
     * Creates a minHeap with the given capacity
     * @param capacity the capacity to set
     */
    public MinHeap(int capacity) {
        this.size = 0;
        heap = new Item[capacity + 1];
        
        FlightLeg leg = new FlightLeg(new Airport("", 5, 6), new Airport("", 4, 7));
        Item item = new Item(-1, leg);
        heap[0] = item;
    }
 
    /**
     * Finds the index of the parent
     * @param index the index which is used as a reference
     * @return the index of the parent
     */
    private int parent(int index) {
        return (index / 2);
    }
 
    /**
     * Finds the left child of the index
     * @param index the index which is used as a reference
     * @return the index of the left child
     */
    private int leftChild(int index) {
        return (2 * index);
    }
 
    /**
     * Finds the right child of the index
     * @param index the index which is used as a reference
     * @return the index of the right child
     */
    private int rightChild(int index) {
        return (2 * index) + 1;
    }
 
    /**
     * Determines of the index is a leaf within the heap
     * @param index the index to test
     * @return true is the index is a leaf, false otherwise
     */
    public boolean isLeaf(int index) {
        if ((index >  (size / 2))  &&  (index <= size)) { 
            return true;
        }
        return false;
    }
 
    /**
     * Swaps the objects at the specified indexes
     * @param firstIndex the first index to switch
     * @param secondIndex the second index to switch
     */
    private void swap(int firstIndex, int secondIndex) {
        Item tmp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = tmp;
    }
 
    /**
     * Makes sure the heap stays balanced with the minimum value
     * at the top of the heap
     * @param index the index to check
     */
    private void downHeap(int index) {
        if (!isLeaf(index)) {
        	
            if ((heap[index].getKey() > heap[leftChild(index)].getKey()  || 
              heap[index].getKey() > heap[rightChild(index)].getKey()) && 
              (heap[leftChild(index)].getKey() < heap[rightChild(index)].getKey())) {
                swap(index, leftChild(index));
                downHeap(leftChild(index));
                    
            } else if ((heap[index].getKey() > heap[leftChild(index)].getKey()  || 
              heap[index].getKey() > heap[rightChild(index)].getKey()) && 
              (heap[leftChild(index)].getKey() > heap[rightChild(index)].getKey())) {
                swap(index, rightChild(index));
                downHeap(rightChild(index));
            }
        }
    }
 
    /**
     * Inserts a FlightLeg object at the specified object
     * @param key the key of the object
     * @param object the FlightLeg object to be inserted
     */
    public void insert(double key, FlightLeg object) {
    	Item item = new Item(key, object);
    	
        heap[++size] = item;
        int current = size;
        
        while (heap[current].getKey() < heap[parent(current)].getKey()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 
    /**
     * Deletes the minimum item within the heap
     * @return the item with the minimum value within the heap
     */
    public Item deleteMin() {
    	if (size == 0) {
    		throw new ArrayIndexOutOfBoundsException("Empty heap");
    	}
    	
    	if (size == 1) {
    		Item min = heap[FIRST];
            heap[FIRST] = heap[size--];
            return min;
    	}
    	
        Item min = heap[FIRST];
        heap[FIRST] = heap[size--]; 
        downHeap(FIRST);
        return min;
    }
    
    /**
     * Retrieves the size of the heap
     * @return the size of the heap
     */
    public int size() {
		return this.size;
	}

}
