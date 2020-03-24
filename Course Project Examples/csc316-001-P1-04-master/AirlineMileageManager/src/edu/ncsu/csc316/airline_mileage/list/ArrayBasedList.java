package edu.ncsu.csc316.airline_mileage.list;

import java.util.AbstractList;

/**
 * ArrayBasedList<E> is a custom list which can allow for the storage of lists of objects
 * @author Aasiyah Feisal (anfeisal)
 *
 * @param <E> is an abstract elements which can represent a variety of objects
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	/** The default capacity for the list */
	private static final int DEFAULT_CAPACITY = 10;
	
	/** The list that stores elements */
	private E[] list;
	/** The size of the list */
	private int size;

	/**
	 * Constructs an empty ArrayList with a default capacity of 10
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		list = (E[])(new Object[DEFAULT_CAPACITY]);
		size = 0;
	}

	/**
	 * Adds an element at the given index.
	 * Any elements after the index are shifted one position to the right.
	 * @param index the index to add an element at.
	 * @param element the element to add
	 */
	@Override
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
	 * Resizes the array to fit new elements
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] temp = list;
		list = (E[])(new Object[list.length * 2]);

		System.arraycopy(temp, 0, list, 0, temp.length);
	}
	
	/**
	 * Gets the value at the given index.
	 * @param index the index to get an element at.
	 * @return the value at the index.
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		return list[index];
	}

	/**
	 * Sets the element at the given index to the given value.
	 * @param index the index to set an element at.
	 * @param element the element to set
	 * @return the old value at the index.
	 */
	@Override
	public E set(int index, E element) {
		if (element == null)
			throw new NullPointerException();
		
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
	 * Removes the element at the given index.
	 * Each element after the removed element is shifted one position to the left.
	 * @param index the index to remove an element at.
	 * @return the element that was removed.
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		E temp = list[index];
		
		for (int i = index; i < size - 1; i++)
			list[i] = list[i + 1];
		
		list[--size] = null;
		return temp;
	}
	
	/**
	 * Returns the size of the ArrayList.
	 * @return the size of the ArrayList.
	 */
	@Override
	public int size() {
		return size;
	}
}