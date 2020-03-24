package edu.ncsu.csc316.airline_mileage.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the ArrayBasedList class
 * @author Aasiyah Feisal
 *
 */
public class ArrayBasedListTest {

	/**
	 * Tests methods within ArrayBasedList
	 */
	@Test
	public void testMultiPurposeList() {
		ArrayBasedList<String> list = new ArrayBasedList<String>();
		assertEquals(0, list.size());
		
		list.add(0, "ad");
		list.add(1, "bgr");
		list.add(2, "cg");
		list.add(3, "dd");
		list.add(4, "ee");
		list.add(5, "fsd");
		list.add(6, "ggf");
		list.add(7, "hhr");
		list.add(8, "ifr");
		list.add(9, "jkj");
		assertEquals(10, list.size());
		
		list.add(10, "kfr");
		assertEquals(11, list.size());
		
		try {
			list.add(-1, list.set(-1, "lj"));
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}	
	}

	/**
	 * Tests add(E) method
	 */
	@Test
	public void testAddIntE() {
		ArrayBasedList<String> list = new ArrayBasedList<String>();
		ArrayBasedList<String> listTwo = new ArrayBasedList<String>(5);
		
		list.add(0, "ak");
		list.add(1, "bf");
		list.add(1, "cr");
		list.add(0, "de");
		
		listTwo.add(0, "ak");
		listTwo.add(1, "bf");
		listTwo.add(1, "cr");
		listTwo.add(0, "de");
		
		assertEquals(4, list.size());
		assertEquals("de", list.get(0));
		assertEquals("ak", list.get(1));
		assertEquals("cr", list.get(2));
		assertEquals("bf", list.get(3));
		
		assertEquals(4, listTwo.size());
		assertEquals("de", listTwo.get(0));
		assertEquals("ak", listTwo.get(1));
		assertEquals("cr", listTwo.get(2));
		assertEquals("bf", listTwo.get(3));
		
		try {
			list.add(-1, "zoinks");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}		

		try {
			list.add(11, "bleh");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}
	}

	/**
	 * Tests get(int) method
	 */
	@Test
	public void testGetInt() {
		ArrayBasedList<String> list = new ArrayBasedList<String>();
		list.add(0, "af");
		list.add(1, "bg");
		list.add(1, "cf");
		list.add(0, "de");
		
		assertEquals(4, list.size());
		assertEquals("de", list.get(0));
		assertEquals("af", list.get(1));
		assertEquals("cf", list.get(2));
		assertEquals("bg", list.get(3));
		
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}		

		try {
			list.get(10);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}
		
		try {
			list.get(11);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}
	}
}
