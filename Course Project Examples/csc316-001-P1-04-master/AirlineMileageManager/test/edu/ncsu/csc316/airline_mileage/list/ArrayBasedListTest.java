package edu.ncsu.csc316.airline_mileage.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Tests ArrayBasedList class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class ArrayBasedListTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.list.ArrayBasedList#ArrayBasedList()}.
	 */
	@Test
	public void testArrayBasedList() {
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
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.list.ArrayBasedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		ArrayBasedList<String> list = new ArrayBasedList<String>();
		list.add(0, "ak");
		list.add(1, "bf");
		list.add(1, "cr");
		list.add(0, "de");
		
		assertEquals(4, list.size());
		assertEquals("de", list.get(0));
		assertEquals("ak", list.get(1));
		assertEquals("cr", list.get(2));
		assertEquals("bf", list.get(3));
		
		try {
			list.add(0, null);
			fail();
		} catch (NullPointerException e) {
			//catches exception
		}
		
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
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.list.ArrayBasedList#get(int)}.
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
	
	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.list.ArrayBasedList#set(int,E)}.
	 */
	@Test
	public void testSetIntE() {
	    ArrayBasedList<String> list = new ArrayBasedList<String>();
	    
	    try {
	    	list.set(0, "a");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}
	    
	    list.add(0, "ae");
	    list.add(1, "br");
	    list.add(1, "cg");
	    list.add(0, "df");
	    list.set(0, "fw");
	    list.set(2, "lt");
	
	
	    assertEquals(4, list.size());
	    assertEquals("fw", list.get(0));
	    assertEquals("ae", list.get(1));
	    assertEquals("lt", list.get(2));
	    assertEquals("br", list.get(3));
	
		try {
			list.set(0, null);
			fail();
		} catch (NullPointerException e) {
			//catches exception
		}
	
		try {
			list.set(1, "arg");
		} catch (IllegalArgumentException e) {
			//catches exception
		}
		
		try {
			list.set(-1, "zip");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}		
	
		try {
			list.set(11, "gip");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//catches exception
		}
	}

}
