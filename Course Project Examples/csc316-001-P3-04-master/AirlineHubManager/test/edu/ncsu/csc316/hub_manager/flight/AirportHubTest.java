package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the AirportHub class
 * @author Aasiyah Feisal
 *
 */
public class AirportHubTest {

	/**
	 * Tests methods within AirportHub
	 */
	@Test
	public void test() {
		Airport port = new Airport("DIA", 35.2, 45.7);
		
		int connections = 0;
		AirportHub hub = new AirportHub(port, connections);
		assertEquals(port, hub.getPotentialHub());
		assertEquals(0, hub.getConnections());
		
		hub.incConnections();
		assertEquals(1, hub.getConnections());
	}

}
