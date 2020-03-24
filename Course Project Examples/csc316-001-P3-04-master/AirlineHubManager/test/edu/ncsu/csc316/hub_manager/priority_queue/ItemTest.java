package edu.ncsu.csc316.hub_manager.priority_queue;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;

/**
 * Tests the Item class
 * @author Aasiyah Feisal
 *
 */
public class ItemTest {

	/** Sets test key value to 5 */
	private final int testKey = 5;
	
	/**
	 * Tests methods within Item
	 */
	@Test
	public void test() {
		Airport port = new Airport("RDU", 35.2, -63);
		Airport port2 = new Airport("RDU", 35.2, -63);
		FlightLeg leg = new FlightLeg(port, port2);
		Item item = new Item(testKey, leg);
		
		assertEquals(leg, item.getElement());
		if(item.getKey() != 5) {
			fail();
		}
	}

}
