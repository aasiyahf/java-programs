package edu.ncsu.csc316.airline_mileage.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

/**
 * Tests AirlineMileageManager class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class AirlineMileageManagerTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager#AirlineMileageManager(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@SuppressWarnings("unused")
    @Test
	public void testAirlineMileageManager() {
		AirlineMileageManager manager = new AirlineMileageManager("input/airlineFile.txt", "input/customerFile.txt", "input/flightFile.txt");
		String actual = manager.getMiles("Erick", "Mcfarland");
		
		String expected = "Erick Mcfarland earned\n" + "    3591 miles with United Airlines (UA)\n" + 
		  "    516 miles with Delta Air Lines (DL)\n" + "    319 miles with JetBlue Airways (B6)\n";
		
		assertEquals(expected, actual);	   
		
		boolean fail = false;
		try {
		    String report = manager.getMileageReport();
		} catch (IllegalArgumentException e) {
		    fail = true;
		}
		
		assertFalse(fail);
	}

}
