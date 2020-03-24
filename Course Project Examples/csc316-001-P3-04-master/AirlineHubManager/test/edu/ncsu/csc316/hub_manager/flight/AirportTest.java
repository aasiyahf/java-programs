package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Airport class
 * @author Aasiyah Feisal
 *
 */
public class AirportTest {

	/**
	 * Tests methods within Airport
	 */
	@Test
	public void test() {
		Airport port = new Airport("DIA", 31.2, 45.6);
		assertEquals("DIA", port.getAirportCode());
		assert (port.getLatitude() == 31.2);
		assert (port.getLongitude() == 45.6);
	}

}
