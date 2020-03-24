package edu.ncsu.csc316.airline_mileage.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Miles;
import edu.ncsu.csc316.airline_mileage.data.Name;
import edu.ncsu.csc316.airline_mileage.dictionary.ArrayBasedList;

/**
 * Tests AirlineMileageManager class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class AirlineMileageManagerTest {

	
	/**
	 * Tests methods for AirlineMileageManager class
	 */
	@Test
	public void test() {
		AirlineMileageManager manager = new AirlineMileageManager("input/airlineFile.txt", "input/customerFile.txt", "input/flightFile.txt");
		String actual = manager.getMiles("Erick", "Mcfarland");
		
		String expected = "Erick Mcfarland earned\n" + "    3591 miles with United Airlines (UA)\n" + 
		  "    516 miles with Delta Air Lines (DL)\n" + "    319 miles with JetBlue Airways (B6)\n";
		
		assertEquals(expected, actual);
		
		AirlineMileageManager manager2 = new AirlineMileageManager("input/airlineFile.txt", "input/customerFile.txt", "input/flightFile.txt");
		actual = manager2.getMileageReport();
		
		expected = "Erick Mcfarland earned\n" + "    3591 miles with United Airlines (UA)\n" + 
				  "    516 miles with Delta Air Lines (DL)\n" + "    319 miles with JetBlue Airways (B6)\n\n" +
				  "Kassandra Stiltner earned\n" + "    5985 miles with United Airlines (UA)\n\n";
		assertEquals(expected, actual);
		
		ArrayBasedList<Name> names = new ArrayBasedList<Name>();
		names.add(new Name("John", "Smith"));
		names.add(new Name("Jane", "Smith"));
		names.add(new Name("Adam", "Beaver"));
		names = manager.sortNames(names);
		assertEquals("Adam", names.get(0).getFirstName());
		
		ArrayBasedList<Miles> miles = new ArrayBasedList<Miles>();
		miles.add(new Miles("UA", 136));
		miles.add(new Miles("AU", 136));
		miles.add(new Miles("B6", 54));
		miles = manager.sortMiles(miles);
		assertEquals("AU", miles.get(0).getAirline());
	}

}
