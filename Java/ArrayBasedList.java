package edu.ncsu.csc316.airline_mileage.dictionary;

/**
 * ArrayBasedList is a custom list which can allow for the storage of lists of objects
 * and acts like a resizable array list
 * @author Aasiyah Feisal (anfeisal)
 *
 * @param <E> is an abstract elements which can represent a variety of objects
 */
public class ArrayBasedList<E> {

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
	public ArrayBasedList() {
		list = (E[])(new Object[DEFAULT_CAPACITY]);
		size = 0;

		for(int i = 0; i < DEFAULT_CAPACITY; i++) {
			list[i] = null;
		}
	}

	/**
	 * Constructs an empty list with a capacity which is specified
	 * @param size the size to set for the array list
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int size) {
		list = (E[])(new Object[size]);
		size = 0;

		for(int i = 0; i < size; i++) {
			list[i] = null;
		}
	}

	/**
	 * Adds an element at the end of the list
	 * @param element the element to add
	 */
	public void add(E element) {

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
	 * Sets the element at the given index to the given value.
	 * @param index the index to set an element at.
	 * @param element the element to set
	 * @return the old value at the index.
	 */
	public E set(int index, E element) {

		if (this.size() == 0) {
			throw new IndexOutOfBoundsException();
		}

		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		E temp = list[index];
		list[index] = element;
		return temp;
	}

	/**
	 * Determines if element already exists in array
	 * @param element the element to be found
	 * @return true if the array contains the element, false otherwise
	 */
	public boolean contains(E element) {
		for (int i = 0; i < size; i++) {
			if(list[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
}
