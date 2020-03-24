package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the FlightLeg class
 * @author Aasiyah Feisal
 *
 */
public class FlightLegTest {

	/**
	 * Tests methods within FlightLeg
	 */
	@Test
	public void test() {
		Airport origin = new Airport("DFW", 32.89680099487305, -97.03800201416016);
		Airport destination = new Airport("MIA", 25.79319953918457, -80.29060363769531);
		
		FlightLeg flightLeg = new FlightLeg(origin, destination);
		assertEquals(origin, flightLeg.getOrigin());
		assertEquals(destination, flightLeg.getDestination());
		if(flightLeg.getDistance() < 0) {
			fail();
		}
	}

}
