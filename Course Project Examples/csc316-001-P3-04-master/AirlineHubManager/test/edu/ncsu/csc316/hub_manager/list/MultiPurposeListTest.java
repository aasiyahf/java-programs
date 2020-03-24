package edu.ncsu.csc316.hub_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the MultiPurposeList class
 * @author Aasiyah Feisal
 *
 */
public class MultiPurposeListTest {

	/**
	 * Tests methods within MultiPurposeList
	 */
	@Test
	public void testMultiPurposeList() {
		MultiPurposeList<String> list = new MultiPurposeList<String>();
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
	 * Tests add(E) method
	 */
	@Test
	public void testAddIntE() {
		MultiPurposeList<String> list = new MultiPurposeList<String>();
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
	 * Tests get(int) method
	 */
	@Test
	public void testGetInt() {
		MultiPurposeList<String> list = new MultiPurposeList<String>();
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
		
		assertEquals(-1, list.find("g"));
	}
}
