package edu.ncsu.csc316.hub_manager.list;

/**
 * MultiPurposeList is a custom list which can allow for the storage of lists of objects
 * and acts like a resizable array list
 * @author Aasiyah Feisal (anfeisal)
 *
 * @param <E> is an abstract elements which can represent a variety of objects
 */
public class MultiPurposeList<E> {

	/** The default capacity for the list */
	private static final int DEFAULT_CAPACITY = 10;
	
	/** The list that stores elements */
	private E[] list;
	/** The size of the list */
	private int size;

	/**
	 * Constructs an empty list with a default capacity of 10
	 */
	@SuppressWarnings("unchecked")
	public MultiPurposeList() {
		list = (E[])(new Object[DEFAULT_CAPACITY]);
		size = 0;
	}

	/**
	 * Adds an element at the end of the list
	 * @param element the element to add
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		int index = this.size();
		
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (size + 1 >= list.length) {
			resize();
		}

		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}
		
		list[index] = element;
		size++;
	}
	
	/**
	 * Adds an element at the given index
	 * Any elements after the index are shifted one position to the right
	 * @param index the index to add an element at
	 * @param element the element to add
	 */
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (size + 1 >= list.length) {
			resize();
		}

		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}
		
		list[index] = element;
		size++;
	}

	/**
	 * Resizes the list to fit new elements
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] temp = list;
		list = (E[])(new Object[list.length * 2]);

		System.arraycopy(temp, 0, list, 0, temp.length);
	}
	
	/**
	 * Gets the value at the given index
	 * @param index the index to get an element at
	 * @return the value at the index
	 */
	public E get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		return list[index];
	}
	
	/**
	 * Returns the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Finds the index of the specified element
	 * @param element the element to be found
	 * @return the index where the element is located
	 */
	public int find(E element) {
		for (int i = 0; i < size; i++) {
			if(list[i] == element) {
				return i;
			}
		}
		return -1;
	}
}