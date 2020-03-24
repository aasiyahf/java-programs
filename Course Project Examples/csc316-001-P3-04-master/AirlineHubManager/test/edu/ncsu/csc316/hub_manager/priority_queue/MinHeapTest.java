package edu.ncsu.csc316.hub_manager.priority_queue;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;

/**
 * Tests the MinHeap class
 * @author Aasiyah Feisal
 *
 * @param <E> allows for abstract elements to be used
 */
public class MinHeapTest<E> {

	/**
	 * Tests methods within MinHeap
	 */
	@Test
	public void test() {
		MinHeap<FlightLeg> heap = new MinHeap<FlightLeg>(6);
		Airport origin = new Airport("DFW", 32.89680099487305, -97.03800201416016);
		Airport destination = new Airport("MIA", 25.79319953918457, -80.29060363769531);
		
		FlightLeg flightLeg = new FlightLeg(origin, destination);
		heap.insert(10, flightLeg);
		heap.insert(100, flightLeg);
		heap.insert(7, flightLeg);
		heap.insert(30, flightLeg);
		heap.insert(50, flightLeg);
		heap.insert(60, flightLeg);
		
		assertEquals(6, heap.size());
		
		heap.deleteMin();
		heap.deleteMin();
		heap.deleteMin();
		heap.deleteMin();
		heap.deleteMin();
		heap.deleteMin();
		
		try {
			heap.deleteMin();
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {
			//catches exception
		}
	}

}
