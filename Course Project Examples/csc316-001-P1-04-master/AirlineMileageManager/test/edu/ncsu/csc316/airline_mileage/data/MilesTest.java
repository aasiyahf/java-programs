package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Miles;

/**
 * Tests Miles class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class MilesTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.data.Miles#Miles(java.lang.String, int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testMiles() {
		Miles miles = new Miles("UA", 120);
		assertEquals("UA", miles.getAirline());
		assertEquals(120, miles.getMiles());
		
		miles.addMiles(10);
		assertEquals(130, miles.getMiles());
	}

}
