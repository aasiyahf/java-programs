package edu.ncsu.csc316.hub_manager.priority_queue;

import edu.ncsu.csc316.hub_manager.flight.FlightLeg;

/**
 * Creates an item object with a FlightLeg and key of a distance value
 * @author Aasiyah Feisal
 *
 */
public class Item {
	/** Key variable to keep track of weight */
	double key;
	/** FlightLeg element to keep track of edges */
	FlightLeg element;
	
	/**
	 * Constructs a new item object
	 * @param key the distance of the flight
	 * @param object the flight leg object which the item stores
	 */
	public Item(double key, FlightLeg object) {
		this.setKey(key);
		this.setElement(object);
		
	}

	/**
	 * Retrieves the key for the item
	 * @return the key/distance of the item
	 */
	public double getKey() {
		return key;
	}

	/**
	 * Sets the key for the item
	 * @param key the number to set
	 */
	private void setKey(double key) {
		this.key = key;
	}

	/**
	 * Retrieves the FlightLeg contained within the object
	 * @return the flight leg contained in the item
	 */
	public FlightLeg getElement() {
		return element;
	}

	/**
	 * Sets the FlightLeg object for the item
	 * @param element the element to set
	 */
	private void setElement(FlightLeg element) {
		this.element = element;
	}
	
}
